<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
    <xsl:template match="/">
        <ns2:GetAppealScenarioResponse xmlns:ns2="urn://web.gibdd.ru/appeal-fines-gibdd/get-scenario/1.0.2"
                                       xmlns="urn://web.gibdd.ru/appeal-fines-gibdd/commons/common/1.0.2"
                                       xmlns:ns3="urn://web.gibdd.ru/appeal-fines-gibdd/commons/scenario/1.0.2"
                                       Id="R-87d04904-85dc-4ff0-91a8-f98babb5cecf"
                                       ReqId="Q-a7c09763-c077-46eb-8fb6-38356f456404"
                                       timestamp="2020-12-22T18:54:42.945+03:00"
                                       wantCallback="true">
            <Status code="100">
                <Message>Предоставлен ответ</Message>
            </Status>
            <AdditionalData>
                <Item>
                    <Name>offenceCoordinates</Name>
                    <Value>37.440602,55.665008</Value>
                </Item>
            </AdditionalData>
            <ns2:Scenario>
                <ns2:Document attName="5bfd8baf-b05b-4e46-afde-3cace90bd9db" mimeType="application/pdf">
                    <description>Печатная форма постановления</description>
                </ns2:Document>
                <ns2:AppealScenario>
                    <ns3:AppealAllowedBefore>2021-01-01</ns3:AppealAllowedBefore>
                    <ns3:Reasons>
                        <ns3:Top1>
                            <ns3:Reasons>
                                <ns3:Reason code="23">
                                    <ns3:Title>Меня там не было (в этот день)</ns3:Title>
                                    <ns3:Hint>Подсказка по заполнению</ns3:Hint>
                                    <ns3:Evidences>
                                        <ns3:Evidence code="1" required="true" textAllowed="false">
                                            <ns3:Title>Фотоматериалы (фотографии, скриншоты)</ns3:Title>
                                            <ns3:Hint>Подсказка по заполнению</ns3:Hint>
                                            <ns3:AttachmentsAllowed>
                                                <ns3:AttachmentTemplate countMax="2" countMin="1" sizeTotalKB="20480">
                                                    <ns3:FileFormats>
                                                        <ns3:FileFormat code="1">
                                                            <ns3:Title>Растровые изображения</ns3:Title>
                                                            <ns3:FileExtensions>
                                                                <ns3:FileExtension>jpg</ns3:FileExtension>
                                                                <ns3:FileExtension>png</ns3:FileExtension>
                                                            </ns3:FileExtensions>
                                                        </ns3:FileFormat>
                                                    </ns3:FileFormats>
                                                </ns3:AttachmentTemplate>
                                            </ns3:AttachmentsAllowed>
                                        </ns3:Evidence>
                                    </ns3:Evidences>
                                    <ns3:Participation defaultValue="true" readOnly="false"/>
                                </ns3:Reason>
                            </ns3:Reasons>
                        </ns3:Top1>
                        <ns3:Top2>
                            <ns3:Reasons>
                                <ns3:Reason code="28">
                                    <ns3:Title>Неправильно распознан номер</ns3:Title>
                                    <ns3:Hint>Подсказка по заполнению</ns3:Hint>
                                    <ns3:Evidences>
                                        <ns3:Evidence code="0" required="false" textAllowed="true">
                                            <ns3:Title>Текстовое доказательство</ns3:Title>
                                            <ns3:Hint>Подсказка по заполнению</ns3:Hint>
                                        </ns3:Evidence>
                                    </ns3:Evidences>
                                    <ns3:Participation defaultValue="true" readOnly="false"/>
                                </ns3:Reason>
                            </ns3:Reasons>
                        </ns3:Top2>
                        <ns3:Other>
                            <ns3:Reasons>
                                <ns3:Reason code="0">
                                    <ns3:Title>Иная причина</ns3:Title>
                                    <ns3:Hint>Подсказка по заполнению</ns3:Hint>
                                    <ns3:Subject required="true">
                                        <ns3:Hint>Введите суть жалобы</ns3:Hint>
                                    </ns3:Subject>
                                    <ns3:Evidences>
                                        <ns3:Evidence code="0" required="false" textAllowed="true">
                                            <ns3:Title>Текстовое доказательство</ns3:Title>
                                            <ns3:Hint>Подсказка по заполнению</ns3:Hint>
                                        </ns3:Evidence>
                                    </ns3:Evidences>
                                    <ns3:Participation defaultValue="true" readOnly="false"/>
                                </ns3:Reason>
                                <ns3:Reason code="43">
                                    <ns3:Title>Ошибочное измерение скорости</ns3:Title>
                                    <ns3:Hint>Подсказка по заполнению</ns3:Hint>
                                    <ns3:Evidences>
                                        <ns3:Evidence code="0" required="false" textAllowed="true">
                                            <ns3:Title>Текстовое доказательство</ns3:Title>
                                            <ns3:Hint>Подсказка по заполнению</ns3:Hint>
                                        </ns3:Evidence>
                                    </ns3:Evidences>
                                    <ns3:Participation defaultValue="true" readOnly="false"/>
                                </ns3:Reason>
                            </ns3:Reasons>
                        </ns3:Other>
                    </ns3:Reasons>
                </ns2:AppealScenario>
            </ns2:Scenario>
        </ns2:GetAppealScenarioResponse>
    </xsl:template>
</xsl:stylesheet>