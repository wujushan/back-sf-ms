package ru.gosuslugi.pgu.service.descriptor.storage.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gosuslugi.pgu.dto.pdf.GeneratePdfResponseDto;
import ru.gosuslugi.pgu.service.descriptor.storage.controller.model.PutScenarioResponse;
import ru.gosuslugi.pgu.service.descriptor.storage.service.ServiceDescriptorService;

import javax.validation.Valid;

@RestController
public class ServiceDescriptorController {

    private final ServiceDescriptorService service;

    public ServiceDescriptorController(ServiceDescriptorService service) {
        this.service = service;
    }

    /**
     * GET /v1/scenario/{serviceId} : Получение сценария по идентификатору сервиса
     *
     * @param serviceId Идентификатор сервиса (required)
     * @return OK (status code 200)
     *         or Неверные параметры (status code 400)
     *         or Not Found (status code 404)
     *         or Внутренняя ошибка (status code 500)
     */
    @RequestMapping(value = "/v1/scenario/{serviceId}",
            produces = { "application/json;charset=UTF-8" },
            method = RequestMethod.GET)
    @Operation(summary = "Получение сценария по идентификатору сервиса", responses = {
            @ApiResponse(responseCode = "200", description = "Идентификатор сервиса",
                    content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "400", description = "Неверные параметры"),
            @ApiResponse(responseCode = "401", description = "Требуется авторизация"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка")
    })
    ResponseEntity<String> get(@Parameter(name = "serviceId", in = ParameterIn.PATH, description = "ID сервиса", schema = @Schema(type = "string"))
                               @PathVariable("serviceId") String serviceId) {
        return ResponseEntity.ok(service.get(serviceId));
    }

    /**
     * PUT /v1/scenario/{serviceId} : Сохранение сценария.
     *
     * @param serviceId Идентификатор сервиса (required)
     * @param body Json сценария (required)
     * @return OK (status code 200)
     *         or Неверные параметры (status code 400)
     *         or Внутренняя ошибка (status code 500)
     */
    @RequestMapping(value = "/v1/scenario/{serviceId}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    @Operation(summary = "Сохранение сценария", responses = {
            @ApiResponse(responseCode = "200", description = "Идентификатор сервиса",
                    content = @Content(schema = @Schema(implementation = PutScenarioResponse.class))),
            @ApiResponse(responseCode = "400", description = "Неверные параметры"),
            @ApiResponse(responseCode = "401", description = "Требуется авторизация"),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка")
    })
    ResponseEntity<PutScenarioResponse> put(@Parameter(name = "serviceId", in = ParameterIn.PATH, description = "ID сервиса", schema = @Schema(type = "string"))
                                            @PathVariable("serviceId") String serviceId, @Valid @RequestBody String body) {
        return ResponseEntity.ok(new PutScenarioResponse(serviceId, service.save(serviceId, body)));
    }
}
