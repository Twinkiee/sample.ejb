package com.ibm.wsc.cics;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.wsc.bean.CicsObjectWrapper;
import com.ibm.wsc.bean.CommareaWrapperHelper;
import com.ibm.wsc.bean.WOXABC40CommareaWrapper1;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.StringJoiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WOXABC40CommareaWrapper1Handler implements CicsCommunicationHandler {


  private static final Logger logger = LoggerFactory
      .getLogger(WOXABC40CommareaWrapper1Handler.class);

  private CommareaWrapperHelper commareaWrapperHelper;

  @Override
  public boolean isSuitable(String wlxaxmlpDescrizione) {
    return wlxaxmlpDescrizione != null && wlxaxmlpDescrizione.contains("Saldoinquiry");
  }

  @Override
  public CicsObjectWrapper getWrapperInstance(byte[] output) {
    return new WOXABC40CommareaWrapper1Ext(output);
  }

  @Override
  public CicsObjectWrapper getWrapperInstance(String input) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    @SuppressWarnings("unchecked")
    Map<String, Object> inputMap = mapper.readValue(input, Map.class);

    logger.info("Creating commarea wrapper with input map [ {} ]", inputMap);

    final WOXABC40CommareaWrapper1Ext wrapper = new WOXABC40CommareaWrapper1Ext();

    wrapper.setWlxaxmlpAbiIstituto(
        commareaWrapperHelper.getValue(inputMap, "AbiIstituto", String.class));
    wrapper.setWlxaxmlpCab(commareaWrapperHelper.getValue(inputMap, "Cab", String.class));
    wrapper.setWlxaxmlpCabCont(commareaWrapperHelper.getValue(inputMap, "CabCont", String.class));
    wrapper.setWlxaxmlpCanale(commareaWrapperHelper.getValue(inputMap, "Canale", String.class));
    wrapper.setWlxaxmlpDat(commareaWrapperHelper.getValue(inputMap, "Dat", Integer.class));
    wrapper.setWlxaxmlpDatContabile(
        commareaWrapperHelper.getValue(inputMap, "DatContabile", Integer.class));
    wrapper.setWlxaxmlpDescrizione(
        commareaWrapperHelper.getValue(inputMap, "Descrizione", String.class));
    wrapper.setWlxaxmlpEnte(commareaWrapperHelper.getValue(inputMap, "Ente", String.class));
    wrapper.setWlxaxmlpEnteCont(commareaWrapperHelper.getValue(inputMap, "EnteCont", String.class));
    wrapper.setWlxaxmlpIstituto(commareaWrapperHelper.getValue(inputMap, "Istituto", String.class));
    wrapper.setWlxaxmlpOpe(commareaWrapperHelper.getValue(inputMap, "Ope", String.class));
    wrapper.setWlxaxmlpOra(commareaWrapperHelper.getValue(inputMap, "Ora", Integer.class));
    wrapper
        .setWlxaxmlpProcedura(commareaWrapperHelper.getValue(inputMap, "Procedura", String.class));
    wrapper
        .setWlxaxmlpProgramma(commareaWrapperHelper.getValue(inputMap, "Programma", String.class));
    wrapper.setWlxaxmlpReasonCode(
        commareaWrapperHelper.getValue(inputMap, "ReasonCode", String.class));
    wrapper.setWlxaxmlpReturnCode(
        commareaWrapperHelper.getValue(inputMap, "ReturnCode", String.class));
    wrapper.setWlxaxmlpSessionHandle(
        commareaWrapperHelper.getValue(inputMap, "SessionHandle", String.class));
    wrapper.setWlxaxmlpSezione(commareaWrapperHelper.getValue(inputMap, "Sezione", String.class));
    wrapper.setWlxaxmlpSubEnte(commareaWrapperHelper.getValue(inputMap, "SubEnte", String.class));
    wrapper.setWlxaxmlpSubEnteCont(
        commareaWrapperHelper.getValue(inputMap, "SubEnteCont", String.class));
    wrapper.setWlxaxmlpSysid(commareaWrapperHelper.getValue(inputMap, "Sysid", String.class));
    wrapper.setWlxaxmlpTerm(commareaWrapperHelper.getValue(inputMap, "Term", String.class));
    wrapper.setWlxaxmlpTipEnte(commareaWrapperHelper.getValue(inputMap, "TipEnte", String.class));
    wrapper.setWlxaxmlpTipEnteCont(
        commareaWrapperHelper.getValue(inputMap, "TipEnteCont", String.class));
    wrapper.setWlxaxmlpTransazione(
        commareaWrapperHelper.getValue(inputMap, "Transazione", String.class));
    wrapper.setWlxaxmlpUfficio(commareaWrapperHelper.getValue(inputMap, "Ufficio", String.class));
    wrapper.setWoxabc40CatSecOldI(
        commareaWrapperHelper.getValue(inputMap, "CatSecOldI", String.class));
    wrapper.setWoxabc40CodiceI(commareaWrapperHelper.getValue(inputMap, "CodiceI", String.class));
    wrapper.setWoxabc40CodTipExpeI(
        commareaWrapperHelper.getValue(inputMap, "CodTipExpeI", String.class));
    wrapper
        .setWoxabc40DataAperO(commareaWrapperHelper.getValue(inputMap, "DataAperO", Integer.class));
    wrapper
        .setWoxabc40DataEstO(commareaWrapperHelper.getValue(inputMap, "DataEstO", Integer.class));
    wrapper.setWoxabc40DataO(commareaWrapperHelper.getValue(inputMap, "DataO", Integer.class));
    wrapper.setWoxabc40DisponibilitaO(
        commareaWrapperHelper.getValue(inputMap, "DisponibilitaO", BigDecimal.class));
    wrapper
        .setWoxabc40DvCodiceO(commareaWrapperHelper.getValue(inputMap, "DvCodiceO", String.class));
    wrapper.setWoxabc40FidoAssO(
        commareaWrapperHelper.getValue(inputMap, "FidoAssO", BigDecimal.class));
    wrapper.setWoxabc40FidoCassaO(
        commareaWrapperHelper.getValue(inputMap, "FidoCassaO", BigDecimal.class));
    wrapper.setWoxabc40FidoPromiscuoO(
        commareaWrapperHelper.getValue(inputMap, "FidoPromiscuoO", BigDecimal.class));
    wrapper.setWoxabc40FidoSbfO(
        commareaWrapperHelper.getValue(inputMap, "FidoSbfO", BigDecimal.class));
    wrapper.setWoxabc40FilSecOldI(
        commareaWrapperHelper.getValue(inputMap, "FilSecOldI", String.class));
    wrapper.setWoxabc40IntestazioneO(
        commareaWrapperHelper.getValue(inputMap, "IntestazioneO", String.class));
    wrapper.setWoxabc40NumAccordoI(
        commareaWrapperHelper.getValue(inputMap, "NumAccordoI", Long.class));

    final Integer numCtaIntI = commareaWrapperHelper
        .getValue(inputMap, "NumCtaIntI", Integer.class);
    logger.debug("Setting Woxabc40NumCtaIntI with value [ {} ]", numCtaIntI);
    wrapper.setWoxabc40NumCtaIntI(
        numCtaIntI);
    wrapper.setWoxabc40OraO(commareaWrapperHelper.getValue(inputMap, "OraO", Integer.class));
    wrapper.setWoxabc40PartAvvAvereO(
        commareaWrapperHelper.getValue(inputMap, "PartAvvAvereO", BigDecimal.class));
    wrapper.setWoxabc40PartAvvDareO(
        commareaWrapperHelper.getValue(inputMap, "PartAvvDareO", BigDecimal.class));
    wrapper.setWoxabc40PartIndAltO(
        commareaWrapperHelper.getValue(inputMap, "PartIndAltO", BigDecimal.class));
    wrapper.setWoxabc40PartIndAssO(
        commareaWrapperHelper.getValue(inputMap, "PartIndAssO", BigDecimal.class));
    wrapper.setWoxabc40SalContO(
        commareaWrapperHelper.getValue(inputMap, "SalContO", BigDecimal.class));
    wrapper.setWoxabc40SalDispO(
        commareaWrapperHelper.getValue(inputMap, "SalDispO", BigDecimal.class));
    wrapper.setWoxabc40SalLiquidoO(
        commareaWrapperHelper.getValue(inputMap, "SalLiquidoO", BigDecimal.class));
    wrapper.setWoxabc40SalPartIndiO(
        commareaWrapperHelper.getValue(inputMap, "SalPartIndiO", BigDecimal.class));
    wrapper.setWoxabc40SrvSecOldI(
        commareaWrapperHelper.getValue(inputMap, "SrvSecOldI", String.class));
    wrapper
        .setWoxabc40StatoConO(commareaWrapperHelper.getValue(inputMap, "StatoConO", String.class));
    wrapper.setWoxabc40ValoreO(commareaWrapperHelper.getValue(inputMap, "ValoreO", Integer.class));

    try {
      logger.info("Generated wrapper [ {} ]", new String(wrapper.getByteBuffer(),
          "Cp1047"));
    } catch (UnsupportedEncodingException e) {
      logger.warn("Unsupported encoding provided when printing COMMAREA wrapper");
    }
    return wrapper;
  }

  @Override
  public void setHelper(CommareaWrapperHelper helper) {
    this.commareaWrapperHelper = helper;
  }

  public static class WOXABC40CommareaWrapper1Ext extends WOXABC40CommareaWrapper1 implements
      CicsObjectWrapper {

    private WOXABC40CommareaWrapper1 woxabc40CommareaWrapper1;

    public WOXABC40CommareaWrapper1Ext(byte[] buffer) {
      woxabc40CommareaWrapper1 = new WOXABC40CommareaWrapper1(buffer);
    }

    public WOXABC40CommareaWrapper1Ext() {
      woxabc40CommareaWrapper1 = new WOXABC40CommareaWrapper1();
    }

    @Override
    public byte[] getByteBuffer() {
      return woxabc40CommareaWrapper1.getByteBuffer();
    }

    @Override
    public String getWlxaxmlpReturnCode() {
      return woxabc40CommareaWrapper1.getWlxaxmlpReturnCode();
    }

    @Override
    public void setWlxaxmlpReturnCode(String wlxaxmlpReturnCode) {
      woxabc40CommareaWrapper1.setWlxaxmlpReturnCode(wlxaxmlpReturnCode);
    }

    @Override
    public String getWlxaxmlpReasonCode() {
      return woxabc40CommareaWrapper1.getWlxaxmlpReasonCode();
    }

    @Override
    public void setWlxaxmlpReasonCode(String wlxaxmlpReasonCode) {
      woxabc40CommareaWrapper1.setWlxaxmlpReasonCode(wlxaxmlpReasonCode);
    }

    @Override
    public String getWlxaxmlpDescrizione() {
      return woxabc40CommareaWrapper1.getWlxaxmlpDescrizione();
    }

    @Override
    public void setWlxaxmlpDescrizione(String wlxaxmlpDescrizione) {
      woxabc40CommareaWrapper1.setWlxaxmlpDescrizione(wlxaxmlpDescrizione);
    }

    @Override
    public String getWlxaxmlpSessionHandle() {
      return woxabc40CommareaWrapper1.getWlxaxmlpSessionHandle();
    }

    @Override
    public void setWlxaxmlpSessionHandle(String wlxaxmlpSessionHandle) {
      woxabc40CommareaWrapper1.setWlxaxmlpSessionHandle(wlxaxmlpSessionHandle);
    }

    @Override
    public String getWlxaxmlpSysid() {
      return woxabc40CommareaWrapper1.getWlxaxmlpSysid();
    }

    @Override
    public void setWlxaxmlpSysid(String wlxaxmlpSysid) {
      woxabc40CommareaWrapper1.setWlxaxmlpSysid(wlxaxmlpSysid);
    }

    @Override
    public String getWlxaxmlpTransazione() {
      return woxabc40CommareaWrapper1.getWlxaxmlpTransazione();
    }

    @Override
    public void setWlxaxmlpTransazione(String wlxaxmlpTransazione) {
      woxabc40CommareaWrapper1.setWlxaxmlpTransazione(wlxaxmlpTransazione);
    }

    @Override
    public String getWlxaxmlpProgramma() {
      return woxabc40CommareaWrapper1.getWlxaxmlpProgramma();
    }

    @Override
    public void setWlxaxmlpProgramma(String wlxaxmlpProgramma) {
      woxabc40CommareaWrapper1.setWlxaxmlpProgramma(wlxaxmlpProgramma);
    }

    @Override
    public String getWlxaxmlpProcedura() {
      return woxabc40CommareaWrapper1.getWlxaxmlpProcedura();
    }

    @Override
    public void setWlxaxmlpProcedura(String wlxaxmlpProcedura) {
      woxabc40CommareaWrapper1.setWlxaxmlpProcedura(wlxaxmlpProcedura);
    }

    @Override
    public String getWlxaxmlpCanale() {
      return woxabc40CommareaWrapper1.getWlxaxmlpCanale();
    }

    @Override
    public void setWlxaxmlpCanale(String wlxaxmlpCanale) {
      woxabc40CommareaWrapper1.setWlxaxmlpCanale(wlxaxmlpCanale);
    }

    @Override
    public String getWlxaxmlpIstituto() {
      return woxabc40CommareaWrapper1.getWlxaxmlpIstituto();
    }

    @Override
    public void setWlxaxmlpIstituto(String wlxaxmlpIstituto) {
      woxabc40CommareaWrapper1.setWlxaxmlpIstituto(wlxaxmlpIstituto);
    }

    @Override
    public String getWlxaxmlpAbiIstituto() {
      return woxabc40CommareaWrapper1.getWlxaxmlpAbiIstituto();
    }

    @Override
    public void setWlxaxmlpAbiIstituto(String wlxaxmlpAbiIstituto) {
      woxabc40CommareaWrapper1.setWlxaxmlpAbiIstituto(wlxaxmlpAbiIstituto);
    }

    @Override
    public String getWlxaxmlpEnte() {
      return woxabc40CommareaWrapper1.getWlxaxmlpEnte();
    }

    @Override
    public void setWlxaxmlpEnte(String wlxaxmlpEnte) {
      woxabc40CommareaWrapper1.setWlxaxmlpEnte(wlxaxmlpEnte);
    }

    @Override
    public String getWlxaxmlpTipEnte() {
      return woxabc40CommareaWrapper1.getWlxaxmlpTipEnte();
    }

    @Override
    public void setWlxaxmlpTipEnte(String wlxaxmlpTipEnte) {
      woxabc40CommareaWrapper1.setWlxaxmlpTipEnte(wlxaxmlpTipEnte);
    }

    @Override
    public String getWlxaxmlpSubEnte() {
      return woxabc40CommareaWrapper1.getWlxaxmlpSubEnte();
    }

    @Override
    public void setWlxaxmlpSubEnte(String wlxaxmlpSubEnte) {
      woxabc40CommareaWrapper1.setWlxaxmlpSubEnte(wlxaxmlpSubEnte);
    }

    @Override
    public String getWlxaxmlpCab() {
      return woxabc40CommareaWrapper1.getWlxaxmlpCab();
    }

    @Override
    public void setWlxaxmlpCab(String wlxaxmlpCab) {
      woxabc40CommareaWrapper1.setWlxaxmlpCab(wlxaxmlpCab);
    }

    @Override
    public String getWlxaxmlpUfficio() {
      return woxabc40CommareaWrapper1.getWlxaxmlpUfficio();
    }

    @Override
    public void setWlxaxmlpUfficio(String wlxaxmlpUfficio) {
      woxabc40CommareaWrapper1.setWlxaxmlpUfficio(wlxaxmlpUfficio);
    }

    @Override
    public String getWlxaxmlpSezione() {
      return woxabc40CommareaWrapper1.getWlxaxmlpSezione();
    }

    @Override
    public void setWlxaxmlpSezione(String wlxaxmlpSezione) {
      woxabc40CommareaWrapper1.setWlxaxmlpSezione(wlxaxmlpSezione);
    }

    @Override
    public String getWlxaxmlpTerm() {
      return woxabc40CommareaWrapper1.getWlxaxmlpTerm();
    }

    @Override
    public void setWlxaxmlpTerm(String wlxaxmlpTerm) {
      woxabc40CommareaWrapper1.setWlxaxmlpTerm(wlxaxmlpTerm);
    }

    @Override
    public String getWlxaxmlpOpe() {
      return woxabc40CommareaWrapper1.getWlxaxmlpOpe();
    }

    @Override
    public void setWlxaxmlpOpe(String wlxaxmlpOpe) {
      woxabc40CommareaWrapper1.setWlxaxmlpOpe(wlxaxmlpOpe);
    }

    @Override
    public int getWlxaxmlpDat() {
      return woxabc40CommareaWrapper1.getWlxaxmlpDat();
    }

    @Override
    public void setWlxaxmlpDat(int wlxaxmlpDat) {
      woxabc40CommareaWrapper1.setWlxaxmlpDat(wlxaxmlpDat);
    }

    @Override
    public int getWlxaxmlpOra() {
      return woxabc40CommareaWrapper1.getWlxaxmlpOra();
    }

    @Override
    public void setWlxaxmlpOra(int wlxaxmlpOra) {
      woxabc40CommareaWrapper1.setWlxaxmlpOra(wlxaxmlpOra);
    }

    @Override
    public String getWlxaxmlpEnteCont() {
      return woxabc40CommareaWrapper1.getWlxaxmlpEnteCont();
    }

    @Override
    public void setWlxaxmlpEnteCont(String wlxaxmlpEnteCont) {
      woxabc40CommareaWrapper1.setWlxaxmlpEnteCont(wlxaxmlpEnteCont);
    }

    @Override
    public String getWlxaxmlpTipEnteCont() {
      return woxabc40CommareaWrapper1.getWlxaxmlpTipEnteCont();
    }

    @Override
    public void setWlxaxmlpTipEnteCont(String wlxaxmlpTipEnteCont) {
      woxabc40CommareaWrapper1.setWlxaxmlpTipEnteCont(wlxaxmlpTipEnteCont);
    }

    @Override
    public String getWlxaxmlpSubEnteCont() {
      return woxabc40CommareaWrapper1.getWlxaxmlpSubEnteCont();
    }

    @Override
    public void setWlxaxmlpSubEnteCont(String wlxaxmlpSubEnteCont) {
      woxabc40CommareaWrapper1.setWlxaxmlpSubEnteCont(wlxaxmlpSubEnteCont);
    }

    @Override
    public String getWlxaxmlpCabCont() {
      return woxabc40CommareaWrapper1.getWlxaxmlpCabCont();
    }

    @Override
    public void setWlxaxmlpCabCont(String wlxaxmlpCabCont) {
      woxabc40CommareaWrapper1.setWlxaxmlpCabCont(wlxaxmlpCabCont);
    }

    @Override
    public int getWlxaxmlpDatContabile() {
      return woxabc40CommareaWrapper1.getWlxaxmlpDatContabile();
    }

    @Override
    public void setWlxaxmlpDatContabile(int wlxaxmlpDatContabile) {
      woxabc40CommareaWrapper1.setWlxaxmlpDatContabile(wlxaxmlpDatContabile);
    }

    @Override
    public String getWoxabc40CodTipExpeI() {
      return woxabc40CommareaWrapper1.getWoxabc40CodTipExpeI();
    }

    @Override
    public void setWoxabc40CodTipExpeI(String woxabc40CodTipExpeI) {
      woxabc40CommareaWrapper1.setWoxabc40CodTipExpeI(woxabc40CodTipExpeI);
    }

    @Override
    public int getWoxabc40NumCtaIntI() {
      return woxabc40CommareaWrapper1.getWoxabc40NumCtaIntI();
    }

    @Override
    public void setWoxabc40NumCtaIntI(int woxabc40NumCtaIntI) {
      woxabc40CommareaWrapper1.setWoxabc40NumCtaIntI(woxabc40NumCtaIntI);
    }

    @Override
    public String getWoxabc40SrvSecOldI() {
      return woxabc40CommareaWrapper1.getWoxabc40SrvSecOldI();
    }

    @Override
    public void setWoxabc40SrvSecOldI(String woxabc40SrvSecOldI) {
      woxabc40CommareaWrapper1.setWoxabc40SrvSecOldI(woxabc40SrvSecOldI);
    }

    @Override
    public String getWoxabc40FilSecOldI() {
      return woxabc40CommareaWrapper1.getWoxabc40FilSecOldI();
    }

    @Override
    public void setWoxabc40FilSecOldI(String woxabc40FilSecOldI) {
      woxabc40CommareaWrapper1.setWoxabc40FilSecOldI(woxabc40FilSecOldI);
    }

    @Override
    public String getWoxabc40CatSecOldI() {
      return woxabc40CommareaWrapper1.getWoxabc40CatSecOldI();
    }

    @Override
    public void setWoxabc40CatSecOldI(String woxabc40CatSecOldI) {
      woxabc40CommareaWrapper1.setWoxabc40CatSecOldI(woxabc40CatSecOldI);
    }

    @Override
    public long getWoxabc40NumAccordoI() {
      return woxabc40CommareaWrapper1.getWoxabc40NumAccordoI();
    }

    @Override
    public void setWoxabc40NumAccordoI(long woxabc40NumAccordoI) {
      woxabc40CommareaWrapper1.setWoxabc40NumAccordoI(woxabc40NumAccordoI);
    }

    @Override
    public String getWoxabc40CodiceI() {
      return woxabc40CommareaWrapper1.getWoxabc40CodiceI();
    }

    @Override
    public void setWoxabc40CodiceI(String woxabc40CodiceI) {
      woxabc40CommareaWrapper1.setWoxabc40CodiceI(woxabc40CodiceI);
    }

    @Override
    public String getWoxabc40DvCodiceO() {
      return woxabc40CommareaWrapper1.getWoxabc40DvCodiceO();
    }

    @Override
    public void setWoxabc40DvCodiceO(String woxabc40DvCodiceO) {
      woxabc40CommareaWrapper1.setWoxabc40DvCodiceO(woxabc40DvCodiceO);
    }

    @Override
    public String getWoxabc40IntestazioneO() {
      return woxabc40CommareaWrapper1.getWoxabc40IntestazioneO();
    }

    @Override
    public void setWoxabc40IntestazioneO(String woxabc40IntestazioneO) {
      woxabc40CommareaWrapper1.setWoxabc40IntestazioneO(woxabc40IntestazioneO);
    }

    @Override
    public int getWoxabc40ValoreO() {
      return woxabc40CommareaWrapper1.getWoxabc40ValoreO();
    }

    @Override
    public void setWoxabc40ValoreO(int woxabc40ValoreO) {
      woxabc40CommareaWrapper1.setWoxabc40ValoreO(woxabc40ValoreO);
    }

    @Override
    public int getWoxabc40DataO() {
      return woxabc40CommareaWrapper1.getWoxabc40DataO();
    }

    @Override
    public void setWoxabc40DataO(int woxabc40DataO) {
      woxabc40CommareaWrapper1.setWoxabc40DataO(woxabc40DataO);
    }

    @Override
    public int getWoxabc40OraO() {
      return woxabc40CommareaWrapper1.getWoxabc40OraO();
    }

    @Override
    public void setWoxabc40OraO(int woxabc40OraO) {
      woxabc40CommareaWrapper1.setWoxabc40OraO(woxabc40OraO);
    }

    @Override
    public BigDecimal getWoxabc40SalContO() {
      return woxabc40CommareaWrapper1.getWoxabc40SalContO();
    }

    @Override
    public void setWoxabc40SalContO(BigDecimal woxabc40SalContO) {
      woxabc40CommareaWrapper1.setWoxabc40SalContO(woxabc40SalContO);
    }

    @Override
    public BigDecimal getWoxabc40SalLiquidoO() {
      return woxabc40CommareaWrapper1.getWoxabc40SalLiquidoO();
    }

    @Override
    public void setWoxabc40SalLiquidoO(BigDecimal woxabc40SalLiquidoO) {
      woxabc40CommareaWrapper1.setWoxabc40SalLiquidoO(woxabc40SalLiquidoO);
    }

    @Override
    public BigDecimal getWoxabc40SalDispO() {
      return woxabc40CommareaWrapper1.getWoxabc40SalDispO();
    }

    @Override
    public void setWoxabc40SalDispO(BigDecimal woxabc40SalDispO) {
      woxabc40CommareaWrapper1.setWoxabc40SalDispO(woxabc40SalDispO);
    }

    @Override
    public BigDecimal getWoxabc40SalPartIndiO() {
      return woxabc40CommareaWrapper1.getWoxabc40SalPartIndiO();
    }

    @Override
    public void setWoxabc40SalPartIndiO(BigDecimal woxabc40SalPartIndiO) {
      woxabc40CommareaWrapper1.setWoxabc40SalPartIndiO(woxabc40SalPartIndiO);
    }

    @Override
    public BigDecimal getWoxabc40DisponibilitaO() {
      return woxabc40CommareaWrapper1.getWoxabc40DisponibilitaO();
    }

    @Override
    public void setWoxabc40DisponibilitaO(BigDecimal woxabc40DisponibilitaO) {
      woxabc40CommareaWrapper1.setWoxabc40DisponibilitaO(woxabc40DisponibilitaO);
    }

    @Override
    public BigDecimal getWoxabc40PartIndAssO() {
      return woxabc40CommareaWrapper1.getWoxabc40PartIndAssO();
    }

    @Override
    public void setWoxabc40PartIndAssO(BigDecimal woxabc40PartIndAssO) {
      woxabc40CommareaWrapper1.setWoxabc40PartIndAssO(woxabc40PartIndAssO);
    }

    @Override
    public BigDecimal getWoxabc40PartIndAltO() {
      return woxabc40CommareaWrapper1.getWoxabc40PartIndAltO();
    }

    @Override
    public void setWoxabc40PartIndAltO(BigDecimal woxabc40PartIndAltO) {
      woxabc40CommareaWrapper1.setWoxabc40PartIndAltO(woxabc40PartIndAltO);
    }

    @Override
    public BigDecimal getWoxabc40PartAvvDareO() {
      return woxabc40CommareaWrapper1.getWoxabc40PartAvvDareO();
    }

    @Override
    public void setWoxabc40PartAvvDareO(BigDecimal woxabc40PartAvvDareO) {
      woxabc40CommareaWrapper1.setWoxabc40PartAvvDareO(woxabc40PartAvvDareO);
    }

    @Override
    public BigDecimal getWoxabc40PartAvvAvereO() {
      return woxabc40CommareaWrapper1.getWoxabc40PartAvvAvereO();
    }

    @Override
    public void setWoxabc40PartAvvAvereO(BigDecimal woxabc40PartAvvAvereO) {
      woxabc40CommareaWrapper1.setWoxabc40PartAvvAvereO(woxabc40PartAvvAvereO);
    }

    @Override
    public BigDecimal getWoxabc40FidoCassaO() {
      return woxabc40CommareaWrapper1.getWoxabc40FidoCassaO();
    }

    @Override
    public void setWoxabc40FidoCassaO(BigDecimal woxabc40FidoCassaO) {
      woxabc40CommareaWrapper1.setWoxabc40FidoCassaO(woxabc40FidoCassaO);
    }

    @Override
    public BigDecimal getWoxabc40FidoAssO() {
      return woxabc40CommareaWrapper1.getWoxabc40FidoAssO();
    }

    @Override
    public void setWoxabc40FidoAssO(BigDecimal woxabc40FidoAssO) {
      woxabc40CommareaWrapper1.setWoxabc40FidoAssO(woxabc40FidoAssO);
    }

    @Override
    public BigDecimal getWoxabc40FidoSbfO() {
      return woxabc40CommareaWrapper1.getWoxabc40FidoSbfO();
    }

    @Override
    public void setWoxabc40FidoSbfO(BigDecimal woxabc40FidoSbfO) {
      woxabc40CommareaWrapper1.setWoxabc40FidoSbfO(woxabc40FidoSbfO);
    }

    @Override
    public BigDecimal getWoxabc40FidoPromiscuoO() {
      return woxabc40CommareaWrapper1.getWoxabc40FidoPromiscuoO();
    }

    @Override
    public void setWoxabc40FidoPromiscuoO(BigDecimal woxabc40FidoPromiscuoO) {
      woxabc40CommareaWrapper1.setWoxabc40FidoPromiscuoO(woxabc40FidoPromiscuoO);
    }

    @Override
    public int getWoxabc40DataAperO() {
      return woxabc40CommareaWrapper1.getWoxabc40DataAperO();
    }

    @Override
    public void setWoxabc40DataAperO(int woxabc40DataAperO) {
      woxabc40CommareaWrapper1.setWoxabc40DataAperO(woxabc40DataAperO);
    }

    @Override
    public int getWoxabc40DataEstO() {
      return woxabc40CommareaWrapper1.getWoxabc40DataEstO();
    }

    @Override
    public void setWoxabc40DataEstO(int woxabc40DataEstO) {
      woxabc40CommareaWrapper1.setWoxabc40DataEstO(woxabc40DataEstO);
    }

    @Override
    public String getWoxabc40StatoConO() {
      return woxabc40CommareaWrapper1.getWoxabc40StatoConO();
    }

    @Override
    public void setWoxabc40StatoConO(String woxabc40StatoConO) {
      woxabc40CommareaWrapper1.setWoxabc40StatoConO(woxabc40StatoConO);
    }


    @Override
    public String toString() {
      return new StringJoiner(",", WOXABC40CommareaWrapper1Ext.class.getSimpleName() + "[",
          "]")
          .add("wlxaxmlpReturnCode='" + getWlxaxmlpReturnCode() + "'")
          .add("wlxaxmlpReasonCode='" + getWlxaxmlpReasonCode() + "'")
          .add("wlxaxmlpDescrizione='" + getWlxaxmlpDescrizione() + "'")
          .add("wlxaxmlpSessionHandle='" + getWlxaxmlpSessionHandle() + "'")
          .add("wlxaxmlpSysid='" + getWlxaxmlpSysid() + "'")
          .add("wlxaxmlpTransazione='" + getWlxaxmlpTransazione() + "'")
          .add("wlxaxmlpProgramma='" + getWlxaxmlpProgramma() + "'")
          .add("wlxaxmlpProcedura='" + getWlxaxmlpProcedura() + "'")
          .add("wlxaxmlpCanale='" + getWlxaxmlpCanale() + "'")
          .add("wlxaxmlpIstituto='" + getWlxaxmlpIstituto() + "'")
          .add("wlxaxmlpAbiIstituto='" + getWlxaxmlpAbiIstituto() + "'")
          .add("wlxaxmlpEnte='" + getWlxaxmlpEnte() + "'")
          .add("wlxaxmlpTipEnte='" + getWlxaxmlpTipEnte() + "'")
          .add("wlxaxmlpSubEnte='" + getWlxaxmlpSubEnte() + "'")
          .add("wlxaxmlpCab='" + getWlxaxmlpCab() + "'")
          .add("wlxaxmlpUfficio='" + getWlxaxmlpUfficio() + "'")
          .add("wlxaxmlpSezione='" + getWlxaxmlpSezione() + "'")
          .add("wlxaxmlpTerm='" + getWlxaxmlpTerm() + "'")
          .add("wlxaxmlpOpe='" + getWlxaxmlpOpe() + "'")
          .add("wlxaxmlpDat=" + getWlxaxmlpDat())
          .add("wlxaxmlpOra=" + getWlxaxmlpOra())
          .add("wlxaxmlpEnteCont='" + getWlxaxmlpEnteCont() + "'")
          .add("wlxaxmlpTipEnteCont='" + getWlxaxmlpTipEnteCont() + "'")
          .add("wlxaxmlpSubEnteCont='" + getWlxaxmlpSubEnteCont() + "'")
          .add("wlxaxmlpCabCont='" + getWlxaxmlpCabCont() + "'")
          .add("wlxaxmlpDatContabile=" + getWlxaxmlpDatContabile())
          .add("woxabc40CodTipExpeI='" + getWoxabc40CodTipExpeI() + "'")
          .add("woxabc40NumCtaIntI=" + getWoxabc40NumCtaIntI())
          .add("woxabc40SrvSecOldI='" + getWoxabc40SrvSecOldI() + "'")
          .add("woxabc40FilSecOldI='" + getWoxabc40FilSecOldI() + "'")
          .add("woxabc40CatSecOldI='" + getWoxabc40CatSecOldI() + "'")
          .add("woxabc40NumAccordoI=" + getWoxabc40NumAccordoI())
          .add("woxabc40CodiceI='" + getWoxabc40CodiceI() + "'")
          .add("woxabc40DvCodiceO='" + getWoxabc40DvCodiceO() + "'")
          .add("woxabc40IntestazioneO='" + getWoxabc40IntestazioneO() + "'")
          .add("woxabc40ValoreO=" + getWoxabc40ValoreO())
          .add("woxabc40DataO=" + getWoxabc40DataO())
          .add("woxabc40OraO=" + getWoxabc40OraO())
          .add("woxabc40SalContO=" + getWoxabc40SalContO())
          .add("woxabc40SalLiquidoO=" + getWoxabc40SalLiquidoO())
          .add("woxabc40SalDispO=" + getWoxabc40SalDispO())
          .add("woxabc40SalPartIndiO=" + getWoxabc40SalPartIndiO())
          .add("woxabc40DisponibilitaO=" + getWoxabc40DisponibilitaO())
          .add("woxabc40PartIndAssO=" + getWoxabc40PartIndAssO())
          .add("woxabc40PartIndAltO=" + getWoxabc40PartIndAltO())
          .add("woxabc40PartAvvDareO=" + getWoxabc40PartAvvDareO())
          .add("woxabc40PartAvvAvereO=" + getWoxabc40PartAvvAvereO())
          .add("woxabc40FidoCassaO=" + getWoxabc40FidoCassaO())
          .add("woxabc40FidoAssO=" + getWoxabc40FidoAssO())
          .add("woxabc40FidoSbfO=" + getWoxabc40FidoSbfO())
          .add("woxabc40FidoPromiscuoO=" + getWoxabc40FidoPromiscuoO())
          .add("woxabc40DataAperO=" + getWoxabc40DataAperO())
          .add("woxabc40DataEstO=" + getWoxabc40DataEstO())
          .add("woxabc40StatoConO='" + getWoxabc40StatoConO() + "'")
          .toString();
    }
  }
}
