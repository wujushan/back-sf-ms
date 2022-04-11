package ru.gosuslugi.pgu.sp.adapter.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.gosuslugi.pgu.common.core.attachments.AttachmentService;
import ru.gosuslugi.pgu.common.esia.search.dto.UserPersonalData;
import ru.gosuslugi.pgu.sp.adapter.controller.dto.SavedPdfDto;
import ru.gosuslugi.pgu.sp.adapter.controller.dto.SavedPdfRequest;
import ru.gosuslugi.pgu.sp.adapter.data.TemplatesDataContext;
import ru.gosuslugi.pgu.sp.adapter.dto.PdfCreationRequestDto;
import ru.gosuslugi.pgu.sp.adapter.service.SmevPdfService;

import java.awt.print.Book;
import java.util.HashSet;
import java.util.Optional;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * Контроллер  для генерации PDF
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class PdfTemplateController {

    private final UserPersonalData userPersonalData;
    private final SmevPdfService smevPdfService;
    private final AttachmentService attachmentService;
    public static final String PDF_MIME_TYPE = "application/pdf";

    /**
     * Генерация PDF из черновика пользователя. Каждый раз при вызове файл генерируется заново, не сохраняется
     * @param pdfName - практически префикс названия vm-шаблона c ролью Applicant
     * @param orderId - идентификатор черновика
     * @param light - флаг создания PDF из простого шаблона
     * @param needToSave - флаг отвечающий за то, нужно ли сохранять фаил в террабайт или нет
     * @return файл PDF как вложение web ответа.
     * @see MediaType
     */
    @GetMapping("/pdf")
    @Operation(summary = "Генерация PDF из черновика пользователя. Каждый раз при вызове файл генерируется заново, не сохраняется", responses = {
            @ApiResponse(responseCode = "200", description = "файл PDF как вложение web ответа"),
            @ApiResponse(responseCode = "400", description = "Неверные параметры"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка")
    })
    public ResponseEntity<Resource> getPDFFile(
            @Parameter(name = "path", in = ParameterIn.QUERY, description = "практически префикс названия vm-шаблона c ролью Applicant", schema = @Schema(type = "string"))
                @RequestParam("pdfName") String pdfName,
            @Parameter(name = "path", in = ParameterIn.QUERY, description = "идентификатор черновика", schema = @Schema(type = "integer"))
                @RequestParam("orderId") Long orderId,
            @Parameter(name = "path", in = ParameterIn.QUERY, description = "флаг создания PDF из простого шаблона", schema = @Schema(type = "boolean"))
                @RequestParam(name = "light", required = false) Boolean light,
            @Parameter(name = "path", in = ParameterIn.QUERY, description = "флаг отвечающий за то, нужно ли сохранять фаил в террабайт или нет", schema = @Schema(type = "boolean"))
                @RequestParam(name = "needToSave", required = false) Boolean needToSave
    ) {
        val lightMode = light != null && light;
        val userId = userPersonalData.getUserId();
        val orgId = userPersonalData.getOrgId();

        byte[] pdfContent;
        if (lightMode)
            pdfContent = smevPdfService.createApplicationPdf(orderId, userId, orgId, pdfName, TemplatesDataContext.MAIN_ROLE_NAME, false);
        else
            pdfContent = smevPdfService.createAdditionalApplicationPdf(orderId, userId, orgId, pdfName, TemplatesDataContext.MAIN_ROLE_NAME, false);
        if (pdfContent == null) {
            return ResponseEntity.noContent().build();
        }
        val save = needToSave != null && needToSave;
        if (save) {
            attachmentService.saveAttachment(orderId, PDF_MIME_TYPE,
                    pdfName, pdfName, pdfContent, null, new HashSet<>());
        }
        try {
            val bytes = new ByteArrayResource(pdfContent);
            return ResponseEntity.ok()
                    .header("Content-disposition", "attachment; filename=" + pdfName + ".pdf")
                    .contentLength(pdfContent.length)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(bytes);
        } catch (Exception e) {
            log.error(String.format("Ошибка чтения файла pdf pdfName = %s, orderId = %s", pdfName, orderId),e);
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Генерация PDF из черновика пользователя. Каждый раз при вызове файл генерируется заново, не сохраняется
     * @param pdfName - практически префикс названия vm-шаблона c ролью Applicant
     * @param light - флаг создания PDF из простого шаблона
     * @return файл PDF как вложение web ответа.
     * @see MediaType
     */
    @PostMapping("/pdf")
    @Operation(summary = "Генерация PDF из черновика пользователя. Каждый раз при вызове файл генерируется заново, не сохраняется", responses = {
            @ApiResponse(responseCode = "200", description = "файл PDF как вложение web ответа"),
            @ApiResponse(responseCode = "400", description = "Неверные параметры"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка")
    })
    public ResponseEntity<Resource> getPDFFile(
            @Parameter(name = "path", in = ParameterIn.QUERY, description = "практически префикс названия vm-шаблона c ролью Applicant", schema = @Schema(type = "string"))
                @RequestParam("pdfName") String pdfName,
            @RequestBody(description = "DTO со ScenarioDTO", content = @Content(schema=@Schema(implementation = PdfCreationRequestDto.class)))
                PdfCreationRequestDto pdfCreationRequestDto,
            @Parameter(name = "path", in = ParameterIn.QUERY, description = "флаг создания PDF из простого шаблона", schema = @Schema(type = "boolean"))
                @RequestParam(name = "light", required = false) Boolean light
    ) {
        val lightMode = light != null && light;
        val userId = userPersonalData.getUserId();
        val orgId = userPersonalData.getOrgId();
        val order = pdfCreationRequestDto.getScenarioDto();
        byte[] pdfContent;
        if (lightMode)
            pdfContent = smevPdfService.createApplicationPdf(order, userId, orgId, pdfName, TemplatesDataContext.MAIN_ROLE_NAME, false);
        else
            pdfContent = smevPdfService.createAdditionalApplicationPdf(order, userId, orgId, pdfName, TemplatesDataContext.MAIN_ROLE_NAME, false);
        if (pdfContent == null) {
            return ResponseEntity.noContent().build();
        }
        try {
            val bytes = new ByteArrayResource(pdfContent);
            return ResponseEntity.ok()
                    .header("Content-disposition", "attachment; filename=" + pdfName + ".pdf")
                    .contentLength(pdfContent.length)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(bytes);
        } catch (Exception e) {
            log.error(String.format("Ошибка чтения файла pdf pdfName = %s, без указания orderId ", pdfName),e);
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Генерация PDF из черновика пользователя с сохранением в terrabyte.
     * @param body параметры вызова @see {@link SavedPdfRequest}
     * @return {@code 200} - JSON c описанием мнемоники файла, {@code 204} - если по бизнесу не должен сформироваться файл
     * @see SavedPdfDto
     */
    @Operation(summary = "Генерация PDF из черновика пользователя с сохранением в terrabyte.", responses = {
            @ApiResponse(responseCode = "200", description = "JSON c описанием мнемоники файла"),
            @ApiResponse(responseCode = "204", description = "если по бизнесу не должен сформироваться файл"),
            @ApiResponse(responseCode = "400", description = "Неверные параметры"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка")
    })
    @PostMapping("/save/pdf")
    public ResponseEntity<Object> savePdf(
            @RequestBody(description = "параметры вызова", content = @Content(schema=@Schema(implementation = SavedPdfRequest.class)))
                @Validated SavedPdfRequest body) {
        val lightMode = body.getLight() != null && body.getLight();
        val userId = body.getUserId();
        val orgId = body.getOrgId();
        val roleId = Optional.ofNullable(body.getUserRole()).orElse(TemplatesDataContext.MAIN_ROLE_NAME);

        byte[] pdfContent;
        if (lightMode) pdfContent = smevPdfService.createApplicationPdf(body.getOrderId(), userId, orgId, body.getPrefix(), roleId, false);
        else pdfContent = smevPdfService.createAdditionalApplicationPdf(body.getOrderId(), userId, orgId, body.getPrefix(), roleId, false);

        if(pdfContent == null) {
            return ResponseEntity.noContent().build();
        }
        try {
            val mnemonic = attachmentService.saveAttachment(body.getOrderId(), PDF_MIME_TYPE,
                    body.getSavedName(), body.getSavedName(), pdfContent, null, new HashSet<>());
            return ResponseEntity.ok(new SavedPdfDto(mnemonic));
        } catch (Exception e) {
            val errorText = String.format("Error during processing pdf file for orderId %s. Ignoring...", body.getOrderId());
            log.error(errorText, e);
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(errorText);
        }
    }
}
