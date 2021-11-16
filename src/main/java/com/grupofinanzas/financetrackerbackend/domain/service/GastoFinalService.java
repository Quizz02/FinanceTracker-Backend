package com.grupofinanzas.financetrackerbackend.domain.service;

import com.grupofinanzas.financetrackerbackend.domain.model.Cartera;
import com.grupofinanzas.financetrackerbackend.domain.model.Factura;
import com.grupofinanzas.financetrackerbackend.domain.model.GastoFinal;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface GastoFinalService {
    GastoFinal creategfbyletraid(Long letraId, GastoFinal gastoFinal);
    GastoFinal creategfbyreciboid(Long reciboId, GastoFinal gastoFinal);
    GastoFinal creategfbyfacturaid(Long facturaId, GastoFinal gastoFinal);


    List<GastoFinal> getallgastobyFacturaId(Long facturaid);
    List<GastoFinal> getallgastobyLetraId(Long letraid);
    List<GastoFinal> getallgastobyReciboId(Long reciboid);


    Optional<GastoFinal> getgfbyidandfacturaid(Long facturaId,Long gastofinalId);
    Optional<GastoFinal> getgfbyidandletraid(Long letraId,Long gastofinalId);
    Optional<GastoFinal> getgfbyidandreciboid(Long reciboId,Long gastofinalId);



    ResponseEntity<?> deletebyFacturaId(Long facturaId, Long gastofinalId);
    ResponseEntity<?> deletebyLetraId(Long letraId, Long gastofinalId);
    ResponseEntity<?> deletebyReciboId(Long reciboId, Long gastofinalId);




}
