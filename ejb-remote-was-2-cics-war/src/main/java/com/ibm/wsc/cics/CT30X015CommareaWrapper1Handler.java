package com.ibm.wsc.cics;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.wsc.bean.CT30X015CommareaWrapper1;
import com.ibm.wsc.bean.CicsObjectWrapper;
import com.ibm.wsc.bean.CommareaWrapperHelper;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.StringJoiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CT30X015CommareaWrapper1Handler implements CicsCommunicationHandler {

  private static final Logger logger = LoggerFactory
      .getLogger(CT30X015CommareaWrapper1Handler.class);

  private CommareaWrapperHelper commareaWrapperHelper;

  @Override
  public boolean isSuitable(String wlxaxmlpDescrizione) {
    return "PrelievoContantiEsegui".equals(wlxaxmlpDescrizione);
  }

  @Override
  public CicsObjectWrapper getWrapperInstance(byte[] output) {
    return new CT30X015CommareaWrapper1Ext(output);
  }

  @Override
  public CicsObjectWrapper getWrapperInstance(String input) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    @SuppressWarnings("unchecked")
    Map<String, Object> inputMap = mapper.readValue(input, Map.class);

    logger.info("Creating commarea wrapper with input map [ {} ]", inputMap);

    final CT30X015CommareaWrapper1Ext wrapper = new CT30X015CommareaWrapper1Ext();

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
    wrapper.setCt30x015AccSrvI(
        commareaWrapperHelper.getValue(inputMap, "AccSrvI", String.class));
    wrapper.setCt30x015CentroI(
        commareaWrapperHelper.getValue(inputMap, "CentroI", String.class));
    wrapper.setCt30x015CmTotaleEuroI(
        commareaWrapperHelper.getValue(inputMap, "CmTotaleEuroI", BigDecimal.class));
    wrapper.setCt30x015CodCanaleI(
        commareaWrapperHelper.getValue(inputMap, "CodCanaleI", String.class));
    wrapper.setCt30x015CodcatsecI(
        commareaWrapperHelper.getValue(inputMap, "CodcatsecI", Integer.class));
    wrapper.setCt30x015CodErrO(
        commareaWrapperHelper.getValue(inputMap, "CodErrO", Integer.class));
    wrapper.setCt30x015CodfilsecI(
        commareaWrapperHelper.getValue(inputMap, "CodfilsecI", Integer.class));
    wrapper.setCt30x015CodOperacionI(
        commareaWrapperHelper.getValue(inputMap, "CodOperacionI", String.class));
    wrapper.setCt30x015CodProcOrigI(
        commareaWrapperHelper.getValue(inputMap, "CodProcOrigI", String.class));
    wrapper.setCt30x015CodProdI(
        commareaWrapperHelper.getValue(inputMap, "CodProdI", String.class));
    wrapper.setCt30x015CodReferenciaOpeI(
        commareaWrapperHelper.getValue(inputMap, "CodReferencia", String.class));
    wrapper.setCt30x015CodReferI(
        commareaWrapperHelper.getValue(inputMap, "CodReferI", String.class));
    wrapper.setCt30x015CodsrvsecI(
        commareaWrapperHelper.getValue(inputMap, "CodsrvsecI", Integer.class));
    wrapper.setCt30x015CodTipExpeI(
        commareaWrapperHelper.getValue(inputMap, "CodTipExpeI", String.class));
    wrapper.setCt30x015DescErroreO(
        commareaWrapperHelper.getValue(inputMap, "DescErroreO", String.class));
    wrapper.setCt30x015DominioI(
        commareaWrapperHelper.getValue(inputMap, "DominioI", String.class));
    wrapper.setCt30x015FecContableI(
        commareaWrapperHelper.getValue(inputMap, "FecContableI", String.class));
    wrapper.setCt30x015FecDisponibilitaI(
        commareaWrapperHelper.getValue(inputMap, "FecDisponibil", String.class));
    wrapper.setCt30x015FecOperacionI(
        commareaWrapperHelper.getValue(inputMap, "FecOperacionI", String.class));
    wrapper.setCt30x015FecValorI(
        commareaWrapperHelper.getValue(inputMap, "FecValorI", String.class));
    wrapper.setCt30x015IndNaturalezaI(
        commareaWrapperHelper.getValue(inputMap, "IndNaturaleza", String.class));
    wrapper.setCt30x015IndPagoEfecI(
        commareaWrapperHelper.getValue(inputMap, "IndPagoEfecI", String.class));
    wrapper.setCt30x015IsTotaleEuroO(
        commareaWrapperHelper.getValue(inputMap, "IsTotaleEuroO", BigDecimal.class));
    wrapper.setCt30x015NodoI(
        commareaWrapperHelper.getValue(inputMap, "NodoI ", String.class));
    wrapper.setCt30x015NumCtaIntI(
        commareaWrapperHelper.getValue(inputMap, "NumCtaIntI", Integer.class));
    wrapper.setCt30x015NumMessaggioI(
        commareaWrapperHelper.getValue(inputMap, "NumMessaggioI", Integer.class));
    wrapper.setCt30x015NumOperacionO(
        commareaWrapperHelper.getValue(inputMap, "NumOperacionO", Long.class));
    wrapper.setCt30x015NumpartsecI(
        commareaWrapperHelper.getValue(inputMap, "NumpartsecI", Integer.class));
    wrapper.setCt30x015NumUtlMovO(
        commareaWrapperHelper.getValue(inputMap, "NumUtlMovO", Integer.class));
    wrapper.setCt30x015PostazioneI(
        commareaWrapperHelper.getValue(inputMap, "PostazioneI", Integer.class));
    wrapper.setCt30x015ScTotaleEuroO(
        commareaWrapperHelper.getValue(inputMap, "ScTotaleEuroO", BigDecimal.class));
    wrapper.setCt30x015SnTotaleEuroO(
        commareaWrapperHelper.getValue(inputMap, "SnTotaleEuroO", BigDecimal.class));
    wrapper.setCt30x015SpTotaleEuroI(
        commareaWrapperHelper.getValue(inputMap, "SpTotaleEuroI", BigDecimal.class));
    wrapper.setCt30x015SrTotaleEuroI(
        commareaWrapperHelper.getValue(inputMap, "SrTotaleEuroI", BigDecimal.class));
    wrapper.setCt30x015TotaleEuroI(
        commareaWrapperHelper.getValue(inputMap, "TotaleEuroI", BigDecimal.class));
    wrapper.setCt30x015TxtMovimentoI(
        commareaWrapperHelper.getValue(inputMap, "TxtMovimentoI", String.class));
    wrapper.setCt30x015ValoreI(
        commareaWrapperHelper.getValue(inputMap, "ValoreI", Integer.class));

    try {
      logger.info("Generated wrapper [ {} ];\nbyte array [ {} ]", wrapper, new String(wrapper.getByteBuffer(),
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

  public static class CT30X015CommareaWrapper1Ext extends CT30X015CommareaWrapper1 implements
      CicsObjectWrapper {

    private CT30X015CommareaWrapper1 ct30x015CommareaWrapper1;

    public CT30X015CommareaWrapper1Ext(byte[] buffer) {
      ct30x015CommareaWrapper1 = new CT30X015CommareaWrapper1(buffer);
    }

    public CT30X015CommareaWrapper1Ext() {
      ct30x015CommareaWrapper1 = new CT30X015CommareaWrapper1();
    }

    @Override
    public byte[] getByteBuffer() {
      return ct30x015CommareaWrapper1.getByteBuffer();
    }

    @Override
    public String getWlxaxmlpReturnCode() {
      return ct30x015CommareaWrapper1.getWlxaxmlpReturnCode();
    }

    @Override
    public void setWlxaxmlpReturnCode(String wlxaxmlpReturnCode) {
      ct30x015CommareaWrapper1.setWlxaxmlpReturnCode(wlxaxmlpReturnCode);
    }

    @Override
    public String getWlxaxmlpReasonCode() {
      return ct30x015CommareaWrapper1.getWlxaxmlpReasonCode();
    }

    @Override
    public void setWlxaxmlpReasonCode(String wlxaxmlpReasonCode) {
      ct30x015CommareaWrapper1.setWlxaxmlpReasonCode(wlxaxmlpReasonCode);
    }

    @Override
    public String getWlxaxmlpDescrizione() {
      return ct30x015CommareaWrapper1.getWlxaxmlpDescrizione();
    }

    @Override
    public void setWlxaxmlpDescrizione(String wlxaxmlpDescrizione) {
      ct30x015CommareaWrapper1.setWlxaxmlpDescrizione(wlxaxmlpDescrizione);
    }

    @Override
    public String getWlxaxmlpSessionHandle() {
      return ct30x015CommareaWrapper1.getWlxaxmlpSessionHandle();
    }

    @Override
    public void setWlxaxmlpSessionHandle(String wlxaxmlpSessionHandle) {
      ct30x015CommareaWrapper1.setWlxaxmlpSessionHandle(wlxaxmlpSessionHandle);
    }

    @Override
    public String getWlxaxmlpSysid() {
      return ct30x015CommareaWrapper1.getWlxaxmlpSysid();
    }

    @Override
    public void setWlxaxmlpSysid(String wlxaxmlpSysid) {
      ct30x015CommareaWrapper1.setWlxaxmlpSysid(wlxaxmlpSysid);
    }

    @Override
    public String getWlxaxmlpTransazione() {
      return ct30x015CommareaWrapper1.getWlxaxmlpTransazione();
    }

    @Override
    public void setWlxaxmlpTransazione(String wlxaxmlpTransazione) {
      ct30x015CommareaWrapper1.setWlxaxmlpTransazione(wlxaxmlpTransazione);
    }

    @Override
    public String getWlxaxmlpProgramma() {
      return ct30x015CommareaWrapper1.getWlxaxmlpProgramma();
    }

    @Override
    public void setWlxaxmlpProgramma(String wlxaxmlpProgramma) {
      ct30x015CommareaWrapper1.setWlxaxmlpProgramma(wlxaxmlpProgramma);
    }

    @Override
    public String getWlxaxmlpProcedura() {
      return ct30x015CommareaWrapper1.getWlxaxmlpProcedura();
    }

    @Override
    public void setWlxaxmlpProcedura(String wlxaxmlpProcedura) {
      ct30x015CommareaWrapper1.setWlxaxmlpProcedura(wlxaxmlpProcedura);
    }

    @Override
    public String getWlxaxmlpCanale() {
      return ct30x015CommareaWrapper1.getWlxaxmlpCanale();
    }

    @Override
    public void setWlxaxmlpCanale(String wlxaxmlpCanale) {
      ct30x015CommareaWrapper1.setWlxaxmlpCanale(wlxaxmlpCanale);
    }

    @Override
    public String getWlxaxmlpIstituto() {
      return ct30x015CommareaWrapper1.getWlxaxmlpIstituto();
    }

    @Override
    public void setWlxaxmlpIstituto(String wlxaxmlpIstituto) {
      ct30x015CommareaWrapper1.setWlxaxmlpIstituto(wlxaxmlpIstituto);
    }

    @Override
    public String getWlxaxmlpAbiIstituto() {
      return ct30x015CommareaWrapper1.getWlxaxmlpAbiIstituto();
    }

    @Override
    public void setWlxaxmlpAbiIstituto(String wlxaxmlpAbiIstituto) {
      ct30x015CommareaWrapper1.setWlxaxmlpAbiIstituto(wlxaxmlpAbiIstituto);
    }

    @Override
    public String getWlxaxmlpEnte() {
      return ct30x015CommareaWrapper1.getWlxaxmlpEnte();
    }

    @Override
    public void setWlxaxmlpEnte(String wlxaxmlpEnte) {
      ct30x015CommareaWrapper1.setWlxaxmlpEnte(wlxaxmlpEnte);
    }

    @Override
    public String getWlxaxmlpTipEnte() {
      return ct30x015CommareaWrapper1.getWlxaxmlpTipEnte();
    }

    @Override
    public void setWlxaxmlpTipEnte(String wlxaxmlpTipEnte) {
      ct30x015CommareaWrapper1.setWlxaxmlpTipEnte(wlxaxmlpTipEnte);
    }

    @Override
    public String getWlxaxmlpSubEnte() {
      return ct30x015CommareaWrapper1.getWlxaxmlpSubEnte();
    }

    @Override
    public void setWlxaxmlpSubEnte(String wlxaxmlpSubEnte) {
      ct30x015CommareaWrapper1.setWlxaxmlpSubEnte(wlxaxmlpSubEnte);
    }

    @Override
    public String getWlxaxmlpCab() {
      return ct30x015CommareaWrapper1.getWlxaxmlpCab();
    }

    @Override
    public void setWlxaxmlpCab(String wlxaxmlpCab) {
      ct30x015CommareaWrapper1.setWlxaxmlpCab(wlxaxmlpCab);
    }

    @Override
    public String getWlxaxmlpUfficio() {
      return ct30x015CommareaWrapper1.getWlxaxmlpUfficio();
    }

    @Override
    public void setWlxaxmlpUfficio(String wlxaxmlpUfficio) {
      ct30x015CommareaWrapper1.setWlxaxmlpUfficio(wlxaxmlpUfficio);
    }

    @Override
    public String getWlxaxmlpSezione() {
      return ct30x015CommareaWrapper1.getWlxaxmlpSezione();
    }

    @Override
    public void setWlxaxmlpSezione(String wlxaxmlpSezione) {
      ct30x015CommareaWrapper1.setWlxaxmlpSezione(wlxaxmlpSezione);
    }

    @Override
    public String getWlxaxmlpTerm() {
      return ct30x015CommareaWrapper1.getWlxaxmlpTerm();
    }

    @Override
    public void setWlxaxmlpTerm(String wlxaxmlpTerm) {
      ct30x015CommareaWrapper1.setWlxaxmlpTerm(wlxaxmlpTerm);
    }

    @Override
    public String getWlxaxmlpOpe() {
      return ct30x015CommareaWrapper1.getWlxaxmlpOpe();
    }

    @Override
    public void setWlxaxmlpOpe(String wlxaxmlpOpe) {
      ct30x015CommareaWrapper1.setWlxaxmlpOpe(wlxaxmlpOpe);
    }

    @Override
    public int getWlxaxmlpDat() {
      return ct30x015CommareaWrapper1.getWlxaxmlpDat();
    }

    @Override
    public void setWlxaxmlpDat(int wlxaxmlpDat) {
      ct30x015CommareaWrapper1.setWlxaxmlpDat(wlxaxmlpDat);
    }

    @Override
    public int getWlxaxmlpOra() {
      return ct30x015CommareaWrapper1.getWlxaxmlpOra();
    }

    @Override
    public void setWlxaxmlpOra(int wlxaxmlpOra) {
      ct30x015CommareaWrapper1.setWlxaxmlpOra(wlxaxmlpOra);
    }

    @Override
    public String getWlxaxmlpEnteCont() {
      return ct30x015CommareaWrapper1.getWlxaxmlpEnteCont();
    }

    @Override
    public void setWlxaxmlpEnteCont(String wlxaxmlpEnteCont) {
      ct30x015CommareaWrapper1.setWlxaxmlpEnteCont(wlxaxmlpEnteCont);
    }

    @Override
    public String getWlxaxmlpTipEnteCont() {
      return ct30x015CommareaWrapper1.getWlxaxmlpTipEnteCont();
    }

    @Override
    public void setWlxaxmlpTipEnteCont(String wlxaxmlpTipEnteCont) {
      ct30x015CommareaWrapper1.setWlxaxmlpTipEnteCont(wlxaxmlpTipEnteCont);
    }

    @Override
    public String getWlxaxmlpSubEnteCont() {
      return ct30x015CommareaWrapper1.getWlxaxmlpSubEnteCont();
    }

    @Override
    public void setWlxaxmlpSubEnteCont(String wlxaxmlpSubEnteCont) {
      ct30x015CommareaWrapper1.setWlxaxmlpSubEnteCont(wlxaxmlpSubEnteCont);
    }

    @Override
    public String getWlxaxmlpCabCont() {
      return ct30x015CommareaWrapper1.getWlxaxmlpCabCont();
    }

    @Override
    public void setWlxaxmlpCabCont(String wlxaxmlpCabCont) {
      ct30x015CommareaWrapper1.setWlxaxmlpCabCont(wlxaxmlpCabCont);
    }

    @Override
    public int getWlxaxmlpDatContabile() {
      return ct30x015CommareaWrapper1.getWlxaxmlpDatContabile();
    }

    @Override
    public void setWlxaxmlpDatContabile(int wlxaxmlpDatContabile) {
      ct30x015CommareaWrapper1.setWlxaxmlpDatContabile(wlxaxmlpDatContabile);
    }

    @Override
    public String getCt30x015DominioI() {
      return ct30x015CommareaWrapper1.getCt30x015DominioI();
    }

    @Override
    public void setCt30x015DominioI(String ct30x015DominioI) {
      ct30x015CommareaWrapper1.setCt30x015DominioI(ct30x015DominioI);
    }

    @Override
    public String getCt30x015NodoI() {
      return ct30x015CommareaWrapper1.getCt30x015NodoI();
    }

    @Override
    public void setCt30x015NodoI(String ct30x015NodoI) {
      ct30x015CommareaWrapper1.setCt30x015NodoI(ct30x015NodoI);
    }

    @Override
    public int getCt30x015PostazioneI() {
      return ct30x015CommareaWrapper1.getCt30x015PostazioneI();
    }

    @Override
    public void setCt30x015PostazioneI(int ct30x015PostazioneI) {
      ct30x015CommareaWrapper1.setCt30x015PostazioneI(ct30x015PostazioneI);
    }

    @Override
    public String getCt30x015CentroI() {
      return ct30x015CommareaWrapper1.getCt30x015CentroI();
    }

    @Override
    public void setCt30x015CentroI(String ct30x015CentroI) {
      ct30x015CommareaWrapper1.setCt30x015CentroI(ct30x015CentroI);
    }

    @Override
    public int getCt30x015NumMessaggioI() {
      return ct30x015CommareaWrapper1.getCt30x015NumMessaggioI();
    }

    @Override
    public void setCt30x015NumMessaggioI(int ct30x015NumMessaggioI) {
      ct30x015CommareaWrapper1.setCt30x015NumMessaggioI(ct30x015NumMessaggioI);
    }

    @Override
    public String getCt30x015AccSrvI() {
      return ct30x015CommareaWrapper1.getCt30x015AccSrvI();
    }

    @Override
    public void setCt30x015AccSrvI(String ct30x015AccSrvI) {
      ct30x015CommareaWrapper1.setCt30x015AccSrvI(ct30x015AccSrvI);
    }

    @Override
    public int getCt30x015ValoreI() {
      return ct30x015CommareaWrapper1.getCt30x015ValoreI();
    }

    @Override
    public void setCt30x015ValoreI(int ct30x015ValoreI) {
      ct30x015CommareaWrapper1.setCt30x015ValoreI(ct30x015ValoreI);
    }

    @Override
    public int getCt30x015CodsrvsecI() {
      return ct30x015CommareaWrapper1.getCt30x015CodsrvsecI();
    }

    @Override
    public void setCt30x015CodsrvsecI(int ct30x015CodsrvsecI) {
      ct30x015CommareaWrapper1.setCt30x015CodsrvsecI(ct30x015CodsrvsecI);
    }

    @Override
    public int getCt30x015CodfilsecI() {
      return ct30x015CommareaWrapper1.getCt30x015CodfilsecI();
    }

    @Override
    public void setCt30x015CodfilsecI(int ct30x015CodfilsecI) {
      ct30x015CommareaWrapper1.setCt30x015CodfilsecI(ct30x015CodfilsecI);
    }

    @Override
    public int getCt30x015CodcatsecI() {
      return ct30x015CommareaWrapper1.getCt30x015CodcatsecI();
    }

    @Override
    public void setCt30x015CodcatsecI(int ct30x015CodcatsecI) {
      ct30x015CommareaWrapper1.setCt30x015CodcatsecI(ct30x015CodcatsecI);
    }

    @Override
    public int getCt30x015NumpartsecI() {
      return ct30x015CommareaWrapper1.getCt30x015NumpartsecI();
    }

    @Override
    public void setCt30x015NumpartsecI(int ct30x015NumpartsecI) {
      ct30x015CommareaWrapper1.setCt30x015NumpartsecI(ct30x015NumpartsecI);
    }

    @Override
    public String getCt30x015CodTipExpeI() {
      return ct30x015CommareaWrapper1.getCt30x015CodTipExpeI();
    }

    @Override
    public void setCt30x015CodTipExpeI(String ct30x015CodTipExpeI) {
      ct30x015CommareaWrapper1.setCt30x015CodTipExpeI(ct30x015CodTipExpeI);
    }

    @Override
    public int getCt30x015NumCtaIntI() {
      return ct30x015CommareaWrapper1.getCt30x015NumCtaIntI();
    }

    @Override
    public void setCt30x015NumCtaIntI(int ct30x015NumCtaIntI) {
      ct30x015CommareaWrapper1.setCt30x015NumCtaIntI(ct30x015NumCtaIntI);
    }

    @Override
    public String getCt30x015CodOperacionI() {
      return ct30x015CommareaWrapper1.getCt30x015CodOperacionI();
    }

    @Override
    public void setCt30x015CodOperacionI(String ct30x015CodOperacionI) {
      ct30x015CommareaWrapper1.setCt30x015CodOperacionI(ct30x015CodOperacionI);
    }

    @Override
    public String getCt30x015CodReferI() {
      return ct30x015CommareaWrapper1.getCt30x015CodReferI();
    }

    @Override
    public void setCt30x015CodReferI(String ct30x015CodReferI) {
      ct30x015CommareaWrapper1.setCt30x015CodReferI(ct30x015CodReferI);
    }

    @Override
    public String getCt30x015CodReferenciaOpeI() {
      return ct30x015CommareaWrapper1.getCt30x015CodReferenciaOpeI();
    }

    @Override
    public void setCt30x015CodReferenciaOpeI(String ct30x015CodReferenciaOpeI) {
      ct30x015CommareaWrapper1.setCt30x015CodReferenciaOpeI(ct30x015CodReferenciaOpeI);
    }

    @Override
    public String getCt30x015TxtMovimentoI() {
      return ct30x015CommareaWrapper1.getCt30x015TxtMovimentoI();
    }

    @Override
    public void setCt30x015TxtMovimentoI(String ct30x015TxtMovimentoI) {
      ct30x015CommareaWrapper1.setCt30x015TxtMovimentoI(ct30x015TxtMovimentoI);
    }

    @Override
    public String getCt30x015IndNaturalezaI() {
      return ct30x015CommareaWrapper1.getCt30x015IndNaturalezaI();
    }

    @Override
    public void setCt30x015IndNaturalezaI(String ct30x015IndNaturalezaI) {
      ct30x015CommareaWrapper1.setCt30x015IndNaturalezaI(ct30x015IndNaturalezaI);
    }

    @Override
    public String getCt30x015IndPagoEfecI() {
      return ct30x015CommareaWrapper1.getCt30x015IndPagoEfecI();
    }

    @Override
    public void setCt30x015IndPagoEfecI(String ct30x015IndPagoEfecI) {
      ct30x015CommareaWrapper1.setCt30x015IndPagoEfecI(ct30x015IndPagoEfecI);
    }

    @Override
    public String getCt30x015FecContableI() {
      return ct30x015CommareaWrapper1.getCt30x015FecContableI();
    }

    @Override
    public void setCt30x015FecContableI(String ct30x015FecContableI) {
      ct30x015CommareaWrapper1.setCt30x015FecContableI(ct30x015FecContableI);
    }

    @Override
    public String getCt30x015FecValorI() {
      return ct30x015CommareaWrapper1.getCt30x015FecValorI();
    }

    @Override
    public void setCt30x015FecValorI(String ct30x015FecValorI) {
      ct30x015CommareaWrapper1.setCt30x015FecValorI(ct30x015FecValorI);
    }

    @Override
    public String getCt30x015FecDisponibilitaI() {
      return ct30x015CommareaWrapper1.getCt30x015FecDisponibilitaI();
    }

    @Override
    public void setCt30x015FecDisponibilitaI(String ct30x015FecDisponibilitaI) {
      ct30x015CommareaWrapper1.setCt30x015FecDisponibilitaI(ct30x015FecDisponibilitaI);
    }

    @Override
    public String getCt30x015FecOperacionI() {
      return ct30x015CommareaWrapper1.getCt30x015FecOperacionI();
    }

    @Override
    public void setCt30x015FecOperacionI(String ct30x015FecOperacionI) {
      ct30x015CommareaWrapper1.setCt30x015FecOperacionI(ct30x015FecOperacionI);
    }

    @Override
    public String getCt30x015CodProcOrigI() {
      return ct30x015CommareaWrapper1.getCt30x015CodProcOrigI();
    }

    @Override
    public void setCt30x015CodProcOrigI(String ct30x015CodProcOrigI) {
      ct30x015CommareaWrapper1.setCt30x015CodProcOrigI(ct30x015CodProcOrigI);
    }

    @Override
    public String getCt30x015CodCanaleI() {
      return ct30x015CommareaWrapper1.getCt30x015CodCanaleI();
    }

    @Override
    public void setCt30x015CodCanaleI(String ct30x015CodCanaleI) {
      ct30x015CommareaWrapper1.setCt30x015CodCanaleI(ct30x015CodCanaleI);
    }

    @Override
    public BigDecimal getCt30x015TotaleEuroI() {
      return ct30x015CommareaWrapper1.getCt30x015TotaleEuroI();
    }

    @Override
    public void setCt30x015TotaleEuroI(BigDecimal ct30x015TotaleEuroI) {
      ct30x015CommareaWrapper1.setCt30x015TotaleEuroI(ct30x015TotaleEuroI);
    }

    @Override
    public BigDecimal getCt30x015CmTotaleEuroI() {
      return ct30x015CommareaWrapper1.getCt30x015CmTotaleEuroI();
    }

    @Override
    public void setCt30x015CmTotaleEuroI(BigDecimal ct30x015CmTotaleEuroI) {
      ct30x015CommareaWrapper1.setCt30x015CmTotaleEuroI(ct30x015CmTotaleEuroI);
    }

    @Override
    public BigDecimal getCt30x015SpTotaleEuroI() {
      return ct30x015CommareaWrapper1.getCt30x015SpTotaleEuroI();
    }

    @Override
    public void setCt30x015SpTotaleEuroI(BigDecimal ct30x015SpTotaleEuroI) {
      ct30x015CommareaWrapper1.setCt30x015SpTotaleEuroI(ct30x015SpTotaleEuroI);
    }

    @Override
    public BigDecimal getCt30x015SrTotaleEuroI() {
      return ct30x015CommareaWrapper1.getCt30x015SrTotaleEuroI();
    }

    @Override
    public void setCt30x015SrTotaleEuroI(BigDecimal ct30x015SrTotaleEuroI) {
      ct30x015CommareaWrapper1.setCt30x015SrTotaleEuroI(ct30x015SrTotaleEuroI);
    }

    @Override
    public String getCt30x015CodProdI() {
      return ct30x015CommareaWrapper1.getCt30x015CodProdI();
    }

    @Override
    public void setCt30x015CodProdI(String ct30x015CodProdI) {
      ct30x015CommareaWrapper1.setCt30x015CodProdI(ct30x015CodProdI);
    }

    @Override
    public long getCt30x015NumOperacionO() {
      return ct30x015CommareaWrapper1.getCt30x015NumOperacionO();
    }

    @Override
    public void setCt30x015NumOperacionO(long ct30x015NumOperacionO) {
      ct30x015CommareaWrapper1.setCt30x015NumOperacionO(ct30x015NumOperacionO);
    }

    @Override
    public BigDecimal getCt30x015ScTotaleEuroO() {
      return ct30x015CommareaWrapper1.getCt30x015ScTotaleEuroO();
    }

    @Override
    public void setCt30x015ScTotaleEuroO(BigDecimal ct30x015ScTotaleEuroO) {
      ct30x015CommareaWrapper1.setCt30x015ScTotaleEuroO(ct30x015ScTotaleEuroO);
    }

    @Override
    public BigDecimal getCt30x015SnTotaleEuroO() {
      return ct30x015CommareaWrapper1.getCt30x015SnTotaleEuroO();
    }

    @Override
    public void setCt30x015SnTotaleEuroO(BigDecimal ct30x015SnTotaleEuroO) {
      ct30x015CommareaWrapper1.setCt30x015SnTotaleEuroO(ct30x015SnTotaleEuroO);
    }

    @Override
    public int getCt30x015NumUtlMovO() {
      return ct30x015CommareaWrapper1.getCt30x015NumUtlMovO();
    }

    @Override
    public void setCt30x015NumUtlMovO(int ct30x015NumUtlMovO) {
      ct30x015CommareaWrapper1.setCt30x015NumUtlMovO(ct30x015NumUtlMovO);
    }

    @Override
    public BigDecimal getCt30x015IsTotaleEuroO() {
      return ct30x015CommareaWrapper1.getCt30x015IsTotaleEuroO();
    }

    @Override
    public void setCt30x015IsTotaleEuroO(BigDecimal ct30x015IsTotaleEuroO) {
      ct30x015CommareaWrapper1.setCt30x015IsTotaleEuroO(ct30x015IsTotaleEuroO);
    }

    @Override
    public int getCt30x015CodErrO() {
      return ct30x015CommareaWrapper1.getCt30x015CodErrO();
    }

    @Override
    public void setCt30x015CodErrO(int ct30x015CodErrO) {
      ct30x015CommareaWrapper1.setCt30x015CodErrO(ct30x015CodErrO);
    }

    @Override
    public String getCt30x015DescErroreO() {
      return ct30x015CommareaWrapper1.getCt30x015DescErroreO();
    }

    @Override
    public void setCt30x015DescErroreO(String ct30x015DescErroreO) {
      ct30x015CommareaWrapper1.setCt30x015DescErroreO(ct30x015DescErroreO);
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", CT30X015CommareaWrapper1Ext.class.getSimpleName() + "[",
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
          .add("ct30x015DominioI='" + getCt30x015DominioI() + "'")
          .add("ct30x015NodoI='" + getCt30x015NodoI() + "'")
          .add("ct30x015PostazioneI=" + getCt30x015PostazioneI())
          .add("ct30x015CentroI='" + getCt30x015CentroI() + "'")
          .add("ct30x015NumMessaggioI=" + getCt30x015NumMessaggioI())
          .add("ct30x015AccSrvI='" + getCt30x015AccSrvI() + "'")
          .add("ct30x015ValoreI=" + getCt30x015ValoreI())
          .add("ct30x015CodsrvsecI=" + getCt30x015CodsrvsecI())
          .add("ct30x015CodfilsecI=" + getCt30x015CodfilsecI())
          .add("ct30x015CodcatsecI=" + getCt30x015CodcatsecI())
          .add("ct30x015NumpartsecI=" + getCt30x015NumpartsecI())
          .add("ct30x015CodTipExpeI='" + getCt30x015CodTipExpeI() + "'")
          .add("ct30x015NumCtaIntI=" + getCt30x015NumCtaIntI())
          .add("ct30x015CodOperacionI='" + getCt30x015CodOperacionI() + "'")
          .add("ct30x015CodReferI='" + getCt30x015CodReferI() + "'")
          .add("ct30x015CodReferenciaOpeI='" + getCt30x015CodReferenciaOpeI() + "'")
          .add("ct30x015TxtMovimentoI='" + getCt30x015TxtMovimentoI() + "'")
          .add("ct30x015IndNaturalezaI='" + getCt30x015IndNaturalezaI() + "'")
          .add("ct30x015IndPagoEfecI='" + getCt30x015IndPagoEfecI() + "'")
          .add("ct30x015FecContableI='" + getCt30x015FecContableI() + "'")
          .add("ct30x015FecValorI='" + getCt30x015FecValorI() + "'")
          .add("ct30x015FecDisponibilitaI='" + getCt30x015FecDisponibilitaI() + "'")
          .add("ct30x015FecOperacionI='" + getCt30x015FecOperacionI() + "'")
          .add("ct30x015CodProcOrigI='" + getCt30x015CodProcOrigI() + "'")
          .add("ct30x015CodCanaleI='" + getCt30x015CodCanaleI() + "'")
          .add("ct30x015TotaleEuroI=" + getCt30x015TotaleEuroI())
          .add("ct30x015CmTotaleEuroI=" + getCt30x015CmTotaleEuroI())
          .add("ct30x015SpTotaleEuroI=" + getCt30x015SpTotaleEuroI())
          .add("ct30x015SrTotaleEuroI=" + getCt30x015SrTotaleEuroI())
          .add("ct30x015CodProdI='" + getCt30x015CodProdI() + "'")
          .add("ct30x015NumOperacionO=" + getCt30x015NumOperacionO())
          .add("ct30x015ScTotaleEuroO=" + getCt30x015ScTotaleEuroO())
          .add("ct30x015SnTotaleEuroO=" + getCt30x015SnTotaleEuroO())
          .add("ct30x015NumUtlMovO=" + getCt30x015NumUtlMovO())
          .add("ct30x015IsTotaleEuroO=" + getCt30x015IsTotaleEuroO())
          .add("ct30x015CodErrO=" + getCt30x015CodErrO())
          .add("ct30x015DescErroreO='" + getCt30x015DescErroreO() + "'")
          .toString();
    }
  }
}
