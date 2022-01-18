package ru.gosuslugi.pgu.sp.adapter.service;

import lombok.extern.slf4j.Slf4j;
import ru.gosuslugi.pgu.dto.pdf.RenderRequestDto;
import ru.gosuslugi.pgu.sp.adapter.data.TemplatesDataContext;
import ru.gosuslugi.pgu.sp.adapter.types.EscaperType;
import ru.gosuslugi.pgu.sp.adapter.util.EscapeUtil;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public abstract class AbstractTemplateRenderService {

    public Map<String, Object> addParametersToVelocityContext(Map<String, Object> values, EscaperType escaperType) {
        Map<String,Object> result = new HashMap<>();
        values.forEach((key, val) -> result.put(key, EscapeUtil.escapeValue(val, escaperType.getEscaper())));
        return result;
    }


    public RenderRequestDto getRenderRequest(TemplatesDataContext dataContext, String templateFileName, Boolean required, EscaperType escaperType) {
        RenderRequestDto renderRequest = new RenderRequestDto();
        renderRequest.setServiceId(dataContext.getServiceId());
        renderRequest.setOid(dataContext.getOid());
        renderRequest.setOrderId(dataContext.getOrderId());
        renderRequest.setRequired(required);
        renderRequest.setTemplateFileName(templateFileName);
        HashMap<String, Object> values = new HashMap<>();
        values.putAll(dataContext.getValues());
        values.putAll(dataContext.getServiceParameters());
        values.putAll(dataContext.getAdditionalValues());
        renderRequest.setValues(addParametersToVelocityContext(values, escaperType));
        return renderRequest;
    }
}
