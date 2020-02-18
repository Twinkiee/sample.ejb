package com.ibm.cicsdev.bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

public class CT30024XCommareaWrapper1jsonMapper extends CT30024XCommareaWrapper1 {

  private final CT30024XCommareaWrapper1 obj;
  private final ObjectMapper mapper;


  public CT30024XCommareaWrapper1jsonMapper(CT30024XCommareaWrapper1 obj, ObjectMapper mapper) {
    this.obj = obj;
    this.mapper = mapper;
  }

  public String toJson() throws JsonProcessingException {
    return mapper.writeValueAsString(obj);
  }

  public void fromJsonMapObj(String jsonMap) throws JsonProcessingException {
    if (jsonMap == null || jsonMap.isEmpty()) {
      throw new IllegalArgumentException("Input jsonMapObj cannot be null or empty");
    }

    @SuppressWarnings("unchecked")
    Map<String, Object> jsonMapObj = mapper.readValue(jsonMap, Map.class);

    obj.setAccServ(getValue(jsonMapObj, "AccServ", String.class));
//    obj.setAlta                           (  getValue(jsonMapObj,"Alta" ,  Boolean.class  ));
//    obj.setAltro_In_TipDisponibilita      (  getValue(jsonMapObj,"Altro_In_TipDisponibilita" ,  Boolean.class  ));
//    obj.setAltro_In_TipLiquidita          (  getValue(jsonMapObj,"Altro_In_TipLiquidita" ,  Boolean.class  ));
//    obj.setAmbos                          (  getValue(jsonMapObj,"Ambos" ,  Boolean.class  ));
    obj.setAqbfBloDatosAplic(getValue(jsonMapObj, "AqbfBloDatosAplic", String.class));
    obj.setAqbfBloDatosPsi(getValue(jsonMapObj, "AqbfBloDatosPsi", String.class));
    obj.setAqbfCodAplic(getValue(jsonMapObj, "AqbfCodAplic", Integer.class));
    obj.setAqbfCodCentro(getValue(jsonMapObj, "AqbfCodCentro", String.class));
    obj.setAqbfCodDominio(getValue(jsonMapObj, "AqbfCodDominio", Integer.class));
    obj.setAqbfCodDominioAnu(getValue(jsonMapObj, "AqbfCodDominioAnu", Integer.class));
    obj.setAqbfCodDominioEnc(getValue(jsonMapObj, "AqbfCodDominioEnc", Integer.class));
    obj.setAqbfCodEmpresa(getValue(jsonMapObj, "AqbfCodEmpresa", String.class));
    obj.setAqbfCodEnvironment(getValue(jsonMapObj, "AqbfCodEnvironment", String.class));
    obj.setAqbfCodIdioma(getValue(jsonMapObj, "AqbfCodIdioma", String.class));
    obj.setAqbfCodOperEnc(getValue(jsonMapObj, "AqbfCodOperEnc", Integer.class));
    obj.setAqbfCodRad(getValue(jsonMapObj, "AqbfCodRad", Integer.class));
    obj.setAqbfCodServi(getValue(jsonMapObj, "AqbfCodServi", Integer.class));
    obj.setAqbfCodUsuario(getValue(jsonMapObj, "AqbfCodUsuario", String.class));
    obj.setAqbfCodUsuarioAut(getValue(jsonMapObj, "AqbfCodUsuarioAut", String.class));
    obj.setAqbfFemContable(getValue(jsonMapObj, "AqbfFemContable", String.class));
    obj.setAqbfFemContableAnt(getValue(jsonMapObj, "AqbfFemContableAnt", String.class));
    obj.setAqbfFemContableAnu(getValue(jsonMapObj, "AqbfFemContableAnu", String.class));
    obj.setAqbfFemContableEnc(getValue(jsonMapObj, "AqbfFemContableEnc", String.class));
    obj.setAqbfFemMaquina(getValue(jsonMapObj, "AqbfFemMaquina", String.class));
    obj.setAqbfFemOperacion(getValue(jsonMapObj, "AqbfFemOperacion", String.class));
    obj.setAqbfHorMaquina(getValue(jsonMapObj, "AqbfHorMaquina", Integer.class));
    obj.setAqbfIndCallAq(getValue(jsonMapObj, "AqbfIndCallAq", String.class));
    obj.setAqbfIndCallProg(getValue(jsonMapObj, "AqbfIndCallProg", String.class));
    obj.setAqbfIndContable(getValue(jsonMapObj, "AqbfIndContable", Integer.class));
    obj.setAqbfIndOnBatch(getValue(jsonMapObj, "AqbfIndOnBatch", Integer.class));
    obj.setAqbfIndOperacionUlt(getValue(jsonMapObj, "AqbfIndOperacionUlt", Integer.class));
    obj.setAqbfNomPrograma(getValue(jsonMapObj, "AqbfNomPrograma", String.class));
    obj.setAqbfNumAutoriz(getValue(jsonMapObj, "AqbfNumAutoriz", Integer.class));
    obj.setAqbfNumAutorizSec(getValue(jsonMapObj, "AqbfNumAutorizSec", Integer.class));
    obj.setAqbfNumDePuesto(getValue(jsonMapObj, "AqbfNumDePuesto", Integer.class));
    obj.setAqbfNumListRad(getValue(jsonMapObj, "AqbfNumListRad", Integer.class));
    obj.setAqbfNumLongMensOut(getValue(jsonMapObj, "AqbfNumLongMensOut", Integer.class));
    obj.setAqbfNumLontb(getValue(jsonMapObj, "AqbfNumLontb", Integer.class));
    obj.setAqbfNumMensaje(getValue(jsonMapObj, "AqbfNumMensaje", Integer.class));
    obj.setAqbfNumMensajeAnu(getValue(jsonMapObj, "AqbfNumMensajeAnu", Integer.class));
    obj.setAqbfNumMensajesUlt(getValue(jsonMapObj, "AqbfNumMensajesUlt", Integer.class));
    obj.setAqbfNumNodo(getValue(jsonMapObj, "AqbfNumNodo", Integer.class));
    obj.setAqbfNumNodoAnu(getValue(jsonMapObj, "AqbfNumNodoAnu", Integer.class));
    obj.setAqbfNumNodoEnc(getValue(jsonMapObj, "AqbfNumNodoEnc", Integer.class));
    obj.setAqbfNumUlt(getValue(jsonMapObj, "AqbfNumUlt", Integer.class));
    obj.setAqbfPtrListRad(getValue(jsonMapObj, "AqbfPtrListRad", byte[].class));
    obj.setAqbfPtrLocaTb(getValue(jsonMapObj, "AqbfPtrLocaTb", byte[].class));
    obj.setAqbfTipMensaje(getValue(jsonMapObj, "AqbfTipMensaje", Integer.class));
    obj.setAqbfTipServicio(getValue(jsonMapObj, "AqbfTipServicio", Integer.class));
//    obj.setAssegni_In_TipDisponibilita    (  getValue(jsonMapObj,"Assegni_In_TipDisponibilita" ,  Boolean.class  ));
//    obj.setAssegni_In_TipLiquidita        (  getValue(jsonMapObj,"Assegni_In_TipLiquidita" ,  Boolean.class  ));
//    obj.setBaja                           (  getValue(jsonMapObj,"Baja" ,  Boolean.class  ));
//    obj.setBatch_In_AqbfIndOnBatch        (  getValue(jsonMapObj,"Batch_In_AqbfIndOnBatch" ,  Boolean.class  ));
//    obj.setBatch_In_IndOrigenMov          (  getValue(jsonMapObj,"Batch_In_IndOrigenMov" ,  Boolean.class  ));
//    obj.setByteBuffer                     (  getValue(jsonMapObj,"ByteBuffer" ,  byte[].class  ));
//    obj.setCallArchi                      (  getValue(jsonMapObj,"CallArchi" ,  Boolean.class  ));
//    obj.setCallProg                       (  getValue(jsonMapObj,"CallProg" ,  Boolean.class  ));
//    obj.setCheque                         (  getValue(jsonMapObj,"Cheque" ,  Boolean.class  ));
    obj.setCodCanale(getValue(jsonMapObj, "CodCanale", String.class));
    obj.setCodCentOrig(getValue(jsonMapObj, "CodCentOrig", String.class));
    obj.setCodCheck(getValue(jsonMapObj, "CodCheck", String.class));
    obj.setCodDesfi(getValue(jsonMapObj, "CodDesfi", Long.class));
    obj.setCodDigControlcp(getValue(jsonMapObj, "CodDigControlcp", Integer.class));
    obj.setCodDominio(getValue(jsonMapObj, "CodDominio", Integer.class));
    obj.setCodEmpresa(getValue(jsonMapObj, "CodEmpresa", String.class));
    obj.setCodEntCp(getValue(jsonMapObj, "CodEntCp", String.class));
    obj.setCodEstsi(getValue(jsonMapObj, "CodEstsi", String.class));
    obj.setCodGruppoSpesa(getValue(jsonMapObj, "CodGruppoSpesa", String.class));
    obj.setCodIdentifica(getValue(jsonMapObj, "CodIdentifica", String.class));
    obj.setCodMonedaOrig(getValue(jsonMapObj, "CodMonedaOrig", String.class));
    obj.setCodNumDocOficia(getValue(jsonMapObj, "CodNumDocOficia", String.class));
    obj.setCodOperacion(getValue(jsonMapObj, "CodOperacion", String.class));
    obj.setCodPais(getValue(jsonMapObj, "CodPais", String.class));
    obj.setCodProcOrig(getValue(jsonMapObj, "CodProcOrig", String.class));
    obj.setCodRefer(getValue(jsonMapObj, "CodRefer", String.class));
    obj.setCodReferenciaOpe(getValue(jsonMapObj, "CodReferenciaOpe", String.class));
    obj.setCodSucCp(getValue(jsonMapObj, "CodSucCp", Integer.class));
    obj.setCodTipExpe(getValue(jsonMapObj, "CodTipExpe", String.class));
    obj.setCodTipoInterven(getValue(jsonMapObj, "CodTipoInterven", String.class));
    obj.setCodUsuAlta(getValue(jsonMapObj, "CodUsuAlta", String.class));
    obj.setCodUsuModif(getValue(jsonMapObj, "CodUsuModif", String.class));
//    obj.setDebe_In_IndNaturaleza          (  getValue(jsonMapObj,"Debe_In_IndNaturaleza" ,  Boolean.class  ));
    obj.setDecRefAmpliada(getValue(jsonMapObj, "DecRefAmpliada", String.class));
    obj.setFecContable(getValue(jsonMapObj, "FecContable", String.class));
    obj.setFecDisponibilita(getValue(jsonMapObj, "FecDisponibilita", String.class));
    obj.setFecFin(getValue(jsonMapObj, "FecFin", String.class));
    obj.setFechaInicio(getValue(jsonMapObj, "FechaInicio", String.class));
    obj.setFecModificacion(getValue(jsonMapObj, "FecModificacion", String.class));
    obj.setFecOperacion(getValue(jsonMapObj, "FecOperacion", String.class));
    obj.setFecValor(getValue(jsonMapObj, "FecValor", String.class));
    obj.setFecVencimiento(getValue(jsonMapObj, "FecVencimiento", String.class));
    obj.setImpCommissioni(getValue(jsonMapObj, "ImpCommissioni", BigDecimal.class));
    obj.setImpConta(getValue(jsonMapObj, "ImpConta", BigDecimal.class));
    obj.setImpMovimiento(getValue(jsonMapObj, "ImpMovimiento", BigDecimal.class));
    obj.setImpOriginario(getValue(jsonMapObj, "ImpOriginario", BigDecimal.class));
    obj.setImpSpese(getValue(jsonMapObj, "ImpSpese", BigDecimal.class));
    obj.setImpSpeseReclam(getValue(jsonMapObj, "ImpSpeseReclam", BigDecimal.class));
    obj.setIndCondo(getValue(jsonMapObj, "IndCondo", String.class));
    obj.setIndExtraEnvi(getValue(jsonMapObj, "IndExtraEnvi", String.class));
    obj.setIndInvioContab(getValue(jsonMapObj, "IndInvioContab", String.class));
    obj.setIndModTabla(getValue(jsonMapObj, "IndModTabla", String.class));
    obj.setIndMovan(getValue(jsonMapObj, "IndMovan", String.class));
    obj.setIndMovforBlo(getValue(jsonMapObj, "IndMovforBlo", String.class));
    obj.setIndMovforImp(getValue(jsonMapObj, "IndMovforImp", String.class));
    obj.setIndMovforRis(getValue(jsonMapObj, "IndMovforRis", String.class));
    obj.setIndMovforSco(getValue(jsonMapObj, "IndMovforSco", String.class));
    obj.setIndMovforVal(getValue(jsonMapObj, "IndMovforVal", String.class));
    obj.setIndMovst(getValue(jsonMapObj, "IndMovst", String.class));
    obj.setIndNaturaleza(getValue(jsonMapObj, "IndNaturaleza", String.class));
    obj.setIndOperEnlazada(getValue(jsonMapObj, "IndOperEnlazada", String.class));
    obj.setIndOrigenMov(getValue(jsonMapObj, "IndOrigenMov", String.class));
    obj.setIndPteLibreta(getValue(jsonMapObj, "IndPteLibreta", String.class));
    obj.setIndSoporte(getValue(jsonMapObj, "IndSoporte", String.class));
    obj.setIndTrunc(getValue(jsonMapObj, "IndTrunc", String.class));
//    obj.setLibreta                        (  getValue(jsonMapObj,"Libreta" ,  Boolean.class  ));
//    obj.setLlamarAq                       (  getValue(jsonMapObj,"LlamarAq" ,  Boolean.class  ));
//    obj.setLlamarProg                     (  getValue(jsonMapObj,"LlamarProg" ,  Boolean.class  ));
//    obj.setModi                           (  getValue(jsonMapObj,"Modi" ,  Boolean.class  ));
//    obj.setNiente_In_TipDisponibilita     (  getValue(jsonMapObj,"Niente_In_TipDisponibilita" ,  Boolean.class  ));
//    obj.setNiente_In_TipLiquidita         (  getValue(jsonMapObj,"Niente_In_TipLiquidita" ,  Boolean.class  ));
//    obj.setNinguno                        (  getValue(jsonMapObj,"Ninguno" ,  Boolean.class  ));
//    obj.setNoAnulado                      (  getValue(jsonMapObj,"NoAnulado" ,  Boolean.class  ));
//    obj.setNoCallArchi                    (  getValue(jsonMapObj,"NoCallArchi" ,  Boolean.class  ));
//    obj.setNoCallProg                     (  getValue(jsonMapObj,"NoCallProg" ,  Boolean.class  ));
//    obj.setNoCondonado                    (  getValue(jsonMapObj,"NoCondonado" ,  Boolean.class  ));
//    obj.setNoEnviado                      (  getValue(jsonMapObj,"NoEnviado" ,  Boolean.class  ));
//    obj.setNoLlamarAq                     (  getValue(jsonMapObj,"NoLlamarAq" ,  Boolean.class  ));
//    obj.setNoLlamarProg                   (  getValue(jsonMapObj,"NoLlamarProg" ,  Boolean.class  ));
    obj.setNombre(getValue(jsonMapObj, "Nombre", String.class));
//    obj.setNoPendiente                    (  getValue(jsonMapObj,"NoPendiente" ,  Boolean.class  ));
    obj.setNumCtaCont(getValue(jsonMapObj, "NumCtaCont", String.class));
    obj.setNumCtaInt(getValue(jsonMapObj, "NumCtaInt", Integer.class));
    obj.setNumCuentaCp(getValue(jsonMapObj, "NumCuentaCp", Long.class));
    obj.setNumDePuesto(getValue(jsonMapObj, "NumDePuesto", Integer.class));
    obj.setNumeroDocumento(getValue(jsonMapObj, "NumeroDocumento", String.class));
    obj.setNumImposicion(getValue(jsonMapObj, "NumImposicion", Integer.class));
    obj.setNumMovimento(getValue(jsonMapObj, "NumMovimento", Integer.class));
    obj.setNumMovst(getValue(jsonMapObj, "NumMovst", Integer.class));
    obj.setNumNodo(getValue(jsonMapObj, "NumNodo", Integer.class));
    obj.setNumOperacion(getValue(jsonMapObj, "NumOperacion", Long.class));
    obj.setNumOperEnlaza(getValue(jsonMapObj, "NumOperEnlaza", Long.class));
    obj.setNumRelCliente(getValue(jsonMapObj, "NumRelCliente", Long.class));
//    obj.setOffline                        (  getValue(jsonMapObj,"Offline" ,  Boolean.class  ));
//    obj.setOnline                         (  getValue(jsonMapObj,"Online" ,  Boolean.class  ));
//    obj.setOnLine_In_AqbfIndOnBatch       (  getValue(jsonMapObj,"OnLine_In_AqbfIndOnBatch" ,  Boolean.class  ));
//    obj.setOnLine_In_IndOrigenMov         (  getValue(jsonMapObj,"OnLine_In_IndOrigenMov" ,  Boolean.class  ));
//    obj.setOpeContable                    (  getValue(jsonMapObj,"OpeContable" ,  Boolean.class  ));
//    obj.setOpeNoContable                  (  getValue(jsonMapObj,"OpeNoContable" ,  Boolean.class  ));
//    obj.setOpeNoPosting                   (  getValue(jsonMapObj,"OpeNoPosting" ,  Boolean.class  ));
//    obj.setOpePosting                     (  getValue(jsonMapObj,"OpePosting" ,  Boolean.class  ));
//    obj.setPagare                         (  getValue(jsonMapObj,"Pagare" ,  Boolean.class  ));
//    obj.setRecibo                         (  getValue(jsonMapObj,"Recibo" ,  Boolean.class  ));
//    obj.setRecu                           (  getValue(jsonMapObj,"Recu" ,  Boolean.class  ));
//    obj.setReutilOn                       (  getValue(jsonMapObj,"ReutilOn" ,  Boolean.class  ));
//    obj.setReutilOnSic                    (  getValue(jsonMapObj,"ReutilOnSic" ,  Boolean.class  ));
//    obj.setReutilOnSicConf                (  getValue(jsonMapObj,"ReutilOnSicConf" ,  Boolean.class  ));
    obj.setSalActual(getValue(jsonMapObj, "SalActual", BigDecimal.class));
    obj.setSalDesoper(getValue(jsonMapObj, "SalDesoper", BigDecimal.class));
    obj.setSaldo(getValue(jsonMapObj, "Saldo", BigDecimal.class));
//    obj.setSbf_In_TipDisponibilita        (  getValue(jsonMapObj,"Sbf_In_TipDisponibilita" ,  Boolean.class  ));
//    obj.setSbf_In_TipLiquidita            (  getValue(jsonMapObj,"Sbf_In_TipLiquidita" ,  Boolean.class  ));
//    obj.setSiAnulado2                     (  getValue(jsonMapObj,"SiAnulado2" ,  Boolean.class  ));
//    obj.setSiAnulado                      (  getValue(jsonMapObj,"SiAnulado" ,  Boolean.class  ));
//    obj.setSiCondonado                    (  getValue(jsonMapObj,"SiCondonado" ,  Boolean.class  ));
//    obj.setSiEnviado                      (  getValue(jsonMapObj,"SiEnviado" ,  Boolean.class  ));
//    obj.setSiPendiente                    (  getValue(jsonMapObj,"SiPendiente" ,  Boolean.class  ));
//    obj.setTarjeta                        (  getValue(jsonMapObj,"Tarjeta" ,  Boolean.class  ));
    obj.setTimestampAlta(getValue(jsonMapObj, "TimestampAlta", String.class));
    obj.setTimestampSiglo(getValue(jsonMapObj, "TimestampSiglo", String.class));
    obj.setTipDisponibilita(getValue(jsonMapObj, "TipDisponibilita", String.class));
    obj.setTipLiquidita(getValue(jsonMapObj, "TipLiquidita", String.class));
    obj.setTxtMovimiento(getValue(jsonMapObj, "TxtMovimiento", String.class));
//    obj.setVali(getValue(jsonMapObj, "Vali", Boolean.class));
    obj.setWlxaxmlpAbiIstituto(getValue(jsonMapObj, "WlxaxmlpAbiIstituto", String.class));
    obj.setWlxaxmlpCab(getValue(jsonMapObj, "WlxaxmlpCab", String.class));
    obj.setWlxaxmlpCabCont(getValue(jsonMapObj, "WlxaxmlpCabCont", String.class));
    obj.setWlxaxmlpCanale(getValue(jsonMapObj, "WlxaxmlpCanale", String.class));
    obj.setWlxaxmlpDat(getValue(jsonMapObj, "WlxaxmlpDat", Integer.class));
    obj.setWlxaxmlpDatContabile(getValue(jsonMapObj, "WlxaxmlpDatContabile", Integer.class));
    obj.setWlxaxmlpDescrizione(getValue(jsonMapObj, "WlxaxmlpDescrizione", String.class));
    obj.setWlxaxmlpEnte(getValue(jsonMapObj, "WlxaxmlpEnte", String.class));
    obj.setWlxaxmlpEnteCont(getValue(jsonMapObj, "WlxaxmlpEnteCont", String.class));
    obj.setWlxaxmlpIstituto(getValue(jsonMapObj, "WlxaxmlpIstituto", String.class));
    obj.setWlxaxmlpOpe(getValue(jsonMapObj, "WlxaxmlpOpe", String.class));
    obj.setWlxaxmlpOra(getValue(jsonMapObj, "WlxaxmlpOra", Integer.class));
    obj.setWlxaxmlpProcedura(getValue(jsonMapObj, "WlxaxmlpProcedura", String.class));
    obj.setWlxaxmlpProgramma(getValue(jsonMapObj, "WlxaxmlpProgramma", String.class));
    obj.setWlxaxmlpReasonCode(getValue(jsonMapObj, "WlxaxmlpReasonCode", String.class));
    obj.setWlxaxmlpReturnCode(getValue(jsonMapObj, "WlxaxmlpReturnCode", String.class));
    obj.setWlxaxmlpSessionHandle(getValue(jsonMapObj, "WlxaxmlpSessionHandle", String.class));
    obj.setWlxaxmlpSezione(getValue(jsonMapObj, "WlxaxmlpSezione", String.class));
    obj.setWlxaxmlpSubEnte(getValue(jsonMapObj, "WlxaxmlpSubEnte", String.class));
    obj.setWlxaxmlpSubEnteCont(getValue(jsonMapObj, "WlxaxmlpSubEnteCont", String.class));
    obj.setWlxaxmlpSysid(getValue(jsonMapObj, "WlxaxmlpSysid", String.class));
    obj.setWlxaxmlpTerm(getValue(jsonMapObj, "WlxaxmlpTerm", String.class));
    obj.setWlxaxmlpTipEnte(getValue(jsonMapObj, "WlxaxmlpTipEnte", String.class));
    obj.setWlxaxmlpTipEnteCont(getValue(jsonMapObj, "WlxaxmlpTipEnteCont", String.class));
    obj.setWlxaxmlpTransazione(getValue(jsonMapObj, "WlxaxmlpTransazione", String.class));
    obj.setWlxaxmlpUfficio(getValue(jsonMapObj, "WlxaxmlpUfficio", String.class));

  }

  @SuppressWarnings("unchecked")
  private <T> T getValue(Map<String, Object> jsonMapObj, String mapKey, Class<T> clazz) {
    final Object o = jsonMapObj.get(mapKey);
    if (o != null) {
      return (T) o;
    }

    if (Objects.equals(clazz, String.class)) {
      return (T) "";
    }

    if (Objects.equals(clazz, Integer.class)) {
      return (T) Integer.valueOf(0);
    }

    if (Objects.equals(clazz, BigDecimal.class)) {
      return (T) BigDecimal.ZERO;
    }

    if (Objects.equals(clazz, Long.class)) {
      return (T) Long.valueOf(0L);
    }

    throw new IllegalStateException("Unhandled class" + clazz);
  }
}
