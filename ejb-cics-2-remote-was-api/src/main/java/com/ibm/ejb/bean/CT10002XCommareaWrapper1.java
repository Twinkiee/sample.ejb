package com.ibm.ejb.bean;
import com.ibm.jzos.fields.*;

// Generated by com.ibm.jzos.recordgen.cobol.RecordClassGenerator on Tue Feb 11 10:44:29 CET 2020

public class CT10002XCommareaWrapper1 {
	protected static CobolDatatypeFactory factory = new CobolDatatypeFactory();
	static { factory.setStringTrimDefault(false); } 

	/** <pre>
	 01 INPUT-CT10002X. </pre> */
	public static final int INPUT_CT10002X_len = 294; 

	/** <pre>
	    02  WLXAXMLP-RETURN-CODE            PIC X(2). </pre> */
	protected static final StringField WLXAXMLP_RETURN_CODE = factory.getStringField(2);

	/** <pre>
	    02  WLXAXMLP-REASON-CODE            PIC X(8). </pre> */
	protected static final StringField WLXAXMLP_REASON_CODE = factory.getStringField(8);

	/** <pre>
	    02  WLXAXMLP-DESCRIZIONE            PIC X(128). </pre> */
	protected static final StringField WLXAXMLP_DESCRIZIONE = factory.getStringField(128);

	/** <pre>
	    02  WLXAXMLP-SESSION-HANDLE         PIC X(26). </pre> */
	protected static final StringField WLXAXMLP_SESSION_HANDLE = factory.getStringField(26);

	/** <pre>
	    02  WLXAXMLP-DATI-AMBI-IMM. </pre> */
	public static final int WLXAXMLP_DATI_AMBI_IMM_len = 119; 
	public static final int WLXAXMLP_DATI_AMBI_IMM_offset = factory.getOffset();

	/** <pre>
	      03  WLXAXMLP-SYSID                PIC X(8). </pre> */
	protected static final StringField WLXAXMLP_SYSID = factory.getStringField(8);

	/** <pre>
	      03  WLXAXMLP-TRANSAZIONE          PIC X(8). </pre> */
	protected static final StringField WLXAXMLP_TRANSAZIONE = factory.getStringField(8);

	/** <pre>
	      03  WLXAXMLP-PROGRAMMA            PIC X(8). </pre> */
	protected static final StringField WLXAXMLP_PROGRAMMA = factory.getStringField(8);

	/** <pre>
	      03  WLXAXMLP-PROCEDURA            PIC X(2). </pre> */
	protected static final StringField WLXAXMLP_PROCEDURA = factory.getStringField(2);

	/** <pre>
	      03  WLXAXMLP-CANALE               PIC X(3). </pre> */
	protected static final StringField WLXAXMLP_CANALE = factory.getStringField(3);

	/** <pre>
	      03  WLXAXMLP-DATI-ISTITUTO. </pre> */
	public static final int WLXAXMLP_DATI_ISTITUTO_len = 20; 
	public static final int WLXAXMLP_DATI_ISTITUTO_offset = factory.getOffset();

	/** <pre>
	       04  WLXAXMLP-ISTITUTO           PIC X(5). </pre> */
	protected static final StringField WLXAXMLP_ISTITUTO_In_WLXAXMLP_DATI_ISTITUTO = factory.getStringField(5);

	/** <pre>
	       04  WLXAXMLP-ABI-ISTITUTO       PIC X(5). </pre> */
	protected static final StringField WLXAXMLP_ABI_ISTITUTO_In_WLXAXMLP_DATI_ISTITUTO = factory.getStringField(5);

//	/** <pre>
//	       04  WLXAXMLP-ISTITUTO           PIC X(5). </pre> */
//	protected static final StringField WLXAXMLP_ISTITUTO_In_WLXAXMLP_DATI_ISTITUTO = factory.getStringField(5);
//
//	/** <pre>
//	       04  WLXAXMLP-ABI-ISTITUTO       PIC X(5). </pre> */
//	protected static final StringField WLXAXMLP_ABI_ISTITUTO_In_WLXAXMLP_DATI_ISTITUTO = factory.getStringField(5);

	/** <pre>
	     03  WLXAXMLP-DATI-ENTE. </pre> */
	public static final int WLXAXMLP_DATI_ENTE_len = 13; 
	public static final int WLXAXMLP_DATI_ENTE_offset = factory.getOffset();

	/** <pre>
	       04  WLXAXMLP-ENTE               PIC X(5). </pre> */
	protected static final StringField WLXAXMLP_ENTE = factory.getStringField(5);

	/** <pre>
	       04  WLXAXMLP-TIP-ENTE           PIC X(1). </pre> */
	protected static final StringField WLXAXMLP_TIP_ENTE = factory.getStringField(1);

	/** <pre>
	       04  WLXAXMLP-SUB-ENTE           PIC X(2). </pre> */
	protected static final StringField WLXAXMLP_SUB_ENTE = factory.getStringField(2);

	/** <pre>
	       04  WLXAXMLP-CAB                PIC X(5). </pre> */
	protected static final StringField WLXAXMLP_CAB = factory.getStringField(5);

	/** <pre>
	     03  WLXAXMLP-UFFICIO              PIC X(4). </pre> */
	protected static final StringField WLXAXMLP_UFFICIO = factory.getStringField(4);

	/** <pre>
	     03  WLXAXMLP-SEZIONE              PIC X(2). </pre> */
	protected static final StringField WLXAXMLP_SEZIONE = factory.getStringField(2);

	/** <pre>
	     03  WLXAXMLP-TERM                 PIC X(8). </pre> */
	protected static final StringField WLXAXMLP_TERM = factory.getStringField(8);

	/** <pre>
	     03  WLXAXMLP-OPE                  PIC X(8). </pre> */
	protected static final StringField WLXAXMLP_OPE = factory.getStringField(8);

	/** <pre>
	     03  WLXAXMLP-DAT                  PIC 9(8). </pre> */
	protected static final ExternalDecimalAsIntField WLXAXMLP_DAT = factory.getExternalDecimalAsIntField(8, false, false, false, false);

	/** <pre>
	     03  WLXAXMLP-ORA                  PIC 9(6). </pre> */
	protected static final ExternalDecimalAsIntField WLXAXMLP_ORA = factory.getExternalDecimalAsIntField(6, false, false, false, false);

	/** <pre>
	     03  WLXAXMLP-ENTE-CONTABILE. </pre> */
	public static final int WLXAXMLP_ENTE_CONTABILE_len = 13; 
	public static final int WLXAXMLP_ENTE_CONTABILE_offset = factory.getOffset();

	/** <pre>
	       04  WLXAXMLP-ENTE-CONT          PIC X(5). </pre> */
	protected static final StringField WLXAXMLP_ENTE_CONT = factory.getStringField(5);

	/** <pre>
	       04  WLXAXMLP-TIP-ENTE-CONT      PIC X(1). </pre> */
	protected static final StringField WLXAXMLP_TIP_ENTE_CONT = factory.getStringField(1);

	/** <pre>
	       04  WLXAXMLP-SUB-ENTE-CONT      PIC X(2). </pre> */
	protected static final StringField WLXAXMLP_SUB_ENTE_CONT = factory.getStringField(2);

	/** <pre>
	       04  WLXAXMLP-CAB-CONT           PIC X(5). </pre> */
	protected static final StringField WLXAXMLP_CAB_CONT = factory.getStringField(5);

	/** <pre>
	     03  WLXAXMLP-DAT-CONTABILE        PIC 9(8). </pre> */
	protected static final ExternalDecimalAsIntField WLXAXMLP_DAT_CONTABILE = factory.getExternalDecimalAsIntField(8, false, false, false, false);

	/** <pre>
	*AREA DATI *****************************************************
	  02  VAL-CUENTA-I. </pre> */
	public static final int VAL_CUENTA_I_len = 11; 
	public static final int VAL_CUENTA_I_offset = factory.getOffset();

	/** <pre>
	   03  RES-MEN-CT1002I. </pre> */
	public static final int RES_MEN_CT1002I_len = 11; 
	public static final int RES_MEN_CT1002I_offset = factory.getOffset();

	/** <pre>
	     04  CLAVECTA. </pre> */
	public static final int CLAVECTA_len = 11; 
	public static final int CLAVECTA_offset = factory.getOffset();

	/** <pre>
	       05  NUMCUENT. </pre> */
	public static final int NUMCUENT_len = 7; 
	public static final int NUMCUENT_offset = factory.getOffset();

	/** <pre>
	         06  COD-TIP-EXPE                  PIC X(2). </pre> */
	protected static final StringField COD_TIP_EXPE = factory.getStringField(2);

	/** <pre>
	         06  NUM-CTA-INT                   PIC S9(8) COMP-3. </pre> */
	protected static final PackedDecimalAsIntField NUM_CTA_INT = factory.getPackedDecimalAsIntField(8, true);

	/** <pre>
	       05  COD-EMPRESA                     PIC X(4). </pre> */
	protected static final StringField COD_EMPRESA = factory.getStringField(4);

	protected byte[] _byteBuffer;
	// Instance variables used to cache field values
	protected String wlxaxmlpReturnCode;
	protected String wlxaxmlpReasonCode;
	protected String wlxaxmlpDescrizione;
	protected String wlxaxmlpSessionHandle;
	protected String wlxaxmlpSysid;
	protected String wlxaxmlpTransazione;
	protected String wlxaxmlpProgramma;
	protected String wlxaxmlpProcedura;
	protected String wlxaxmlpCanale;
	protected String wlxaxmlpIstituto_In_wlxaxmlpDatiIstituto;
	protected String wlxaxmlpAbiIstituto_In_wlxaxmlpDatiIstituto;
//	protected String wlxaxmlpIstituto_In_wlxaxmlpDatiIstituto;
//	protected String wlxaxmlpAbiIstituto_In_wlxaxmlpDatiIstituto;
	protected String wlxaxmlpEnte;
	protected String wlxaxmlpTipEnte;
	protected String wlxaxmlpSubEnte;
	protected String wlxaxmlpCab;
	protected String wlxaxmlpUfficio;
	protected String wlxaxmlpSezione;
	protected String wlxaxmlpTerm;
	protected String wlxaxmlpOpe;
	protected Integer wlxaxmlpDat;
	protected Integer wlxaxmlpOra;
	protected String wlxaxmlpEnteCont;
	protected String wlxaxmlpTipEnteCont;
	protected String wlxaxmlpSubEnteCont;
	protected String wlxaxmlpCabCont;
	protected Integer wlxaxmlpDatContabile;
	protected String codTipExpe;
	protected Integer numCtaInt;
	protected String codEmpresa;


	public CT10002XCommareaWrapper1 (byte[] buffer) {
		this._byteBuffer = buffer;
	}

	public CT10002XCommareaWrapper1 () {
		this._byteBuffer = new byte[INPUT_CT10002X_len];
	}

	public byte[] getByteBuffer() {
		return _byteBuffer;
	}


	public String getWlxaxmlpReturnCode() {
		if (wlxaxmlpReturnCode == null) {
			wlxaxmlpReturnCode = WLXAXMLP_RETURN_CODE.getString(_byteBuffer);
		}
		return wlxaxmlpReturnCode;
	}

	public void setWlxaxmlpReturnCode(String wlxaxmlpReturnCode) {
		if (WLXAXMLP_RETURN_CODE.equals(this.wlxaxmlpReturnCode, wlxaxmlpReturnCode)) {
			return;
		}
		WLXAXMLP_RETURN_CODE.putString(wlxaxmlpReturnCode, _byteBuffer);
		this.wlxaxmlpReturnCode = wlxaxmlpReturnCode;
	}

	public String getWlxaxmlpReasonCode() {
		if (wlxaxmlpReasonCode == null) {
			wlxaxmlpReasonCode = WLXAXMLP_REASON_CODE.getString(_byteBuffer);
		}
		return wlxaxmlpReasonCode;
	}

	public void setWlxaxmlpReasonCode(String wlxaxmlpReasonCode) {
		if (WLXAXMLP_REASON_CODE.equals(this.wlxaxmlpReasonCode, wlxaxmlpReasonCode)) {
			return;
		}
		WLXAXMLP_REASON_CODE.putString(wlxaxmlpReasonCode, _byteBuffer);
		this.wlxaxmlpReasonCode = wlxaxmlpReasonCode;
	}

	public String getWlxaxmlpDescrizione() {
		if (wlxaxmlpDescrizione == null) {
			wlxaxmlpDescrizione = WLXAXMLP_DESCRIZIONE.getString(_byteBuffer);
		}
		return wlxaxmlpDescrizione;
	}

	public void setWlxaxmlpDescrizione(String wlxaxmlpDescrizione) {
		if (WLXAXMLP_DESCRIZIONE.equals(this.wlxaxmlpDescrizione, wlxaxmlpDescrizione)) {
			return;
		}
		WLXAXMLP_DESCRIZIONE.putString(wlxaxmlpDescrizione, _byteBuffer);
		this.wlxaxmlpDescrizione = wlxaxmlpDescrizione;
	}

	public String getWlxaxmlpSessionHandle() {
		if (wlxaxmlpSessionHandle == null) {
			wlxaxmlpSessionHandle = WLXAXMLP_SESSION_HANDLE.getString(_byteBuffer);
		}
		return wlxaxmlpSessionHandle;
	}

	public void setWlxaxmlpSessionHandle(String wlxaxmlpSessionHandle) {
		if (WLXAXMLP_SESSION_HANDLE.equals(this.wlxaxmlpSessionHandle, wlxaxmlpSessionHandle)) {
			return;
		}
		WLXAXMLP_SESSION_HANDLE.putString(wlxaxmlpSessionHandle, _byteBuffer);
		this.wlxaxmlpSessionHandle = wlxaxmlpSessionHandle;
	}

	public String getWlxaxmlpSysid() {
		if (wlxaxmlpSysid == null) {
			wlxaxmlpSysid = WLXAXMLP_SYSID.getString(_byteBuffer);
		}
		return wlxaxmlpSysid;
	}

	public void setWlxaxmlpSysid(String wlxaxmlpSysid) {
		if (WLXAXMLP_SYSID.equals(this.wlxaxmlpSysid, wlxaxmlpSysid)) {
			return;
		}
		WLXAXMLP_SYSID.putString(wlxaxmlpSysid, _byteBuffer);
		this.wlxaxmlpSysid = wlxaxmlpSysid;
	}

	public String getWlxaxmlpTransazione() {
		if (wlxaxmlpTransazione == null) {
			wlxaxmlpTransazione = WLXAXMLP_TRANSAZIONE.getString(_byteBuffer);
		}
		return wlxaxmlpTransazione;
	}

	public void setWlxaxmlpTransazione(String wlxaxmlpTransazione) {
		if (WLXAXMLP_TRANSAZIONE.equals(this.wlxaxmlpTransazione, wlxaxmlpTransazione)) {
			return;
		}
		WLXAXMLP_TRANSAZIONE.putString(wlxaxmlpTransazione, _byteBuffer);
		this.wlxaxmlpTransazione = wlxaxmlpTransazione;
	}

	public String getWlxaxmlpProgramma() {
		if (wlxaxmlpProgramma == null) {
			wlxaxmlpProgramma = WLXAXMLP_PROGRAMMA.getString(_byteBuffer);
		}
		return wlxaxmlpProgramma;
	}

	public void setWlxaxmlpProgramma(String wlxaxmlpProgramma) {
		if (WLXAXMLP_PROGRAMMA.equals(this.wlxaxmlpProgramma, wlxaxmlpProgramma)) {
			return;
		}
		WLXAXMLP_PROGRAMMA.putString(wlxaxmlpProgramma, _byteBuffer);
		this.wlxaxmlpProgramma = wlxaxmlpProgramma;
	}

	public String getWlxaxmlpProcedura() {
		if (wlxaxmlpProcedura == null) {
			wlxaxmlpProcedura = WLXAXMLP_PROCEDURA.getString(_byteBuffer);
		}
		return wlxaxmlpProcedura;
	}

	public void setWlxaxmlpProcedura(String wlxaxmlpProcedura) {
		if (WLXAXMLP_PROCEDURA.equals(this.wlxaxmlpProcedura, wlxaxmlpProcedura)) {
			return;
		}
		WLXAXMLP_PROCEDURA.putString(wlxaxmlpProcedura, _byteBuffer);
		this.wlxaxmlpProcedura = wlxaxmlpProcedura;
	}

	public String getWlxaxmlpCanale() {
		if (wlxaxmlpCanale == null) {
			wlxaxmlpCanale = WLXAXMLP_CANALE.getString(_byteBuffer);
		}
		return wlxaxmlpCanale;
	}

	public void setWlxaxmlpCanale(String wlxaxmlpCanale) {
		if (WLXAXMLP_CANALE.equals(this.wlxaxmlpCanale, wlxaxmlpCanale)) {
			return;
		}
		WLXAXMLP_CANALE.putString(wlxaxmlpCanale, _byteBuffer);
		this.wlxaxmlpCanale = wlxaxmlpCanale;
	}

//	public String getWlxaxmlpIstituto_In_WlxaxmlpDatiIstituto() {
//		if (wlxaxmlpIstituto_In_wlxaxmlpDatiIstituto == null) {
//			wlxaxmlpIstituto_In_wlxaxmlpDatiIstituto = WLXAXMLP_ISTITUTO_In_WLXAXMLP_DATI_ISTITUTO.getString(_byteBuffer);
//		}
//		return wlxaxmlpIstituto_In_wlxaxmlpDatiIstituto;
//	}
//
//	public void setWlxaxmlpIstituto_In_WlxaxmlpDatiIstituto(String wlxaxmlpIstituto_In_wlxaxmlpDatiIstituto) {
//		if (WLXAXMLP_ISTITUTO_In_WLXAXMLP_DATI_ISTITUTO.equals(this.wlxaxmlpIstituto_In_wlxaxmlpDatiIstituto, wlxaxmlpIstituto_In_wlxaxmlpDatiIstituto)) {
//			return;
//		}
//		WLXAXMLP_ISTITUTO_In_WLXAXMLP_DATI_ISTITUTO.putString(wlxaxmlpIstituto_In_wlxaxmlpDatiIstituto, _byteBuffer);
//		this.wlxaxmlpIstituto_In_wlxaxmlpDatiIstituto = wlxaxmlpIstituto_In_wlxaxmlpDatiIstituto;
//	}
//
//	public String getWlxaxmlpAbiIstituto_In_WlxaxmlpDatiIstituto() {
//		if (wlxaxmlpAbiIstituto_In_wlxaxmlpDatiIstituto == null) {
//			wlxaxmlpAbiIstituto_In_wlxaxmlpDatiIstituto = WLXAXMLP_ABI_ISTITUTO_In_WLXAXMLP_DATI_ISTITUTO.getString(_byteBuffer);
//		}
//		return wlxaxmlpAbiIstituto_In_wlxaxmlpDatiIstituto;
//	}
//
//	public void setWlxaxmlpAbiIstituto_In_WlxaxmlpDatiIstituto(String wlxaxmlpAbiIstituto_In_wlxaxmlpDatiIstituto) {
//		if (WLXAXMLP_ABI_ISTITUTO_In_WLXAXMLP_DATI_ISTITUTO.equals(this.wlxaxmlpAbiIstituto_In_wlxaxmlpDatiIstituto, wlxaxmlpAbiIstituto_In_wlxaxmlpDatiIstituto)) {
//			return;
//		}
//		WLXAXMLP_ABI_ISTITUTO_In_WLXAXMLP_DATI_ISTITUTO.putString(wlxaxmlpAbiIstituto_In_wlxaxmlpDatiIstituto, _byteBuffer);
//		this.wlxaxmlpAbiIstituto_In_wlxaxmlpDatiIstituto = wlxaxmlpAbiIstituto_In_wlxaxmlpDatiIstituto;
//	}
//
//	public String getWlxaxmlpIstituto_In_WlxaxmlpDatiIstituto() {
//		if (wlxaxmlpIstituto_In_wlxaxmlpDatiIstituto == null) {
//			wlxaxmlpIstituto_In_wlxaxmlpDatiIstituto = WLXAXMLP_ISTITUTO_In_WLXAXMLP_DATI_ISTITUTO.getString(_byteBuffer);
//		}
//		return wlxaxmlpIstituto_In_wlxaxmlpDatiIstituto;
//	}
//
//	public void setWlxaxmlpIstituto_In_WlxaxmlpDatiIstituto(String wlxaxmlpIstituto_In_wlxaxmlpDatiIstituto) {
//		if (WLXAXMLP_ISTITUTO_In_WLXAXMLP_DATI_ISTITUTO.equals(this.wlxaxmlpIstituto_In_wlxaxmlpDatiIstituto, wlxaxmlpIstituto_In_wlxaxmlpDatiIstituto)) {
//			return;
//		}
//		WLXAXMLP_ISTITUTO_In_WLXAXMLP_DATI_ISTITUTO.putString(wlxaxmlpIstituto_In_wlxaxmlpDatiIstituto, _byteBuffer);
//		this.wlxaxmlpIstituto_In_wlxaxmlpDatiIstituto = wlxaxmlpIstituto_In_wlxaxmlpDatiIstituto;
//	}
//
//	public String getWlxaxmlpAbiIstituto_In_WlxaxmlpDatiIstituto() {
//		if (wlxaxmlpAbiIstituto_In_wlxaxmlpDatiIstituto == null) {
//			wlxaxmlpAbiIstituto_In_wlxaxmlpDatiIstituto = WLXAXMLP_ABI_ISTITUTO_In_WLXAXMLP_DATI_ISTITUTO.getString(_byteBuffer);
//		}
//		return wlxaxmlpAbiIstituto_In_wlxaxmlpDatiIstituto;
//	}
//
//	public void setWlxaxmlpAbiIstituto_In_WlxaxmlpDatiIstituto(String wlxaxmlpAbiIstituto_In_wlxaxmlpDatiIstituto) {
//		if (WLXAXMLP_ABI_ISTITUTO_In_WLXAXMLP_DATI_ISTITUTO.equals(this.wlxaxmlpAbiIstituto_In_wlxaxmlpDatiIstituto, wlxaxmlpAbiIstituto_In_wlxaxmlpDatiIstituto)) {
//			return;
//		}
//		WLXAXMLP_ABI_ISTITUTO_In_WLXAXMLP_DATI_ISTITUTO.putString(wlxaxmlpAbiIstituto_In_wlxaxmlpDatiIstituto, _byteBuffer);
//		this.wlxaxmlpAbiIstituto_In_wlxaxmlpDatiIstituto = wlxaxmlpAbiIstituto_In_wlxaxmlpDatiIstituto;
//	}

	public String getWlxaxmlpEnte() {
		if (wlxaxmlpEnte == null) {
			wlxaxmlpEnte = WLXAXMLP_ENTE.getString(_byteBuffer);
		}
		return wlxaxmlpEnte;
	}

	public void setWlxaxmlpEnte(String wlxaxmlpEnte) {
		if (WLXAXMLP_ENTE.equals(this.wlxaxmlpEnte, wlxaxmlpEnte)) {
			return;
		}
		WLXAXMLP_ENTE.putString(wlxaxmlpEnte, _byteBuffer);
		this.wlxaxmlpEnte = wlxaxmlpEnte;
	}

	public String getWlxaxmlpTipEnte() {
		if (wlxaxmlpTipEnte == null) {
			wlxaxmlpTipEnte = WLXAXMLP_TIP_ENTE.getString(_byteBuffer);
		}
		return wlxaxmlpTipEnte;
	}

	public void setWlxaxmlpTipEnte(String wlxaxmlpTipEnte) {
		if (WLXAXMLP_TIP_ENTE.equals(this.wlxaxmlpTipEnte, wlxaxmlpTipEnte)) {
			return;
		}
		WLXAXMLP_TIP_ENTE.putString(wlxaxmlpTipEnte, _byteBuffer);
		this.wlxaxmlpTipEnte = wlxaxmlpTipEnte;
	}

	public String getWlxaxmlpSubEnte() {
		if (wlxaxmlpSubEnte == null) {
			wlxaxmlpSubEnte = WLXAXMLP_SUB_ENTE.getString(_byteBuffer);
		}
		return wlxaxmlpSubEnte;
	}

	public void setWlxaxmlpSubEnte(String wlxaxmlpSubEnte) {
		if (WLXAXMLP_SUB_ENTE.equals(this.wlxaxmlpSubEnte, wlxaxmlpSubEnte)) {
			return;
		}
		WLXAXMLP_SUB_ENTE.putString(wlxaxmlpSubEnte, _byteBuffer);
		this.wlxaxmlpSubEnte = wlxaxmlpSubEnte;
	}

	public String getWlxaxmlpCab() {
		if (wlxaxmlpCab == null) {
			wlxaxmlpCab = WLXAXMLP_CAB.getString(_byteBuffer);
		}
		return wlxaxmlpCab;
	}

	public void setWlxaxmlpCab(String wlxaxmlpCab) {
		if (WLXAXMLP_CAB.equals(this.wlxaxmlpCab, wlxaxmlpCab)) {
			return;
		}
		WLXAXMLP_CAB.putString(wlxaxmlpCab, _byteBuffer);
		this.wlxaxmlpCab = wlxaxmlpCab;
	}

	public String getWlxaxmlpUfficio() {
		if (wlxaxmlpUfficio == null) {
			wlxaxmlpUfficio = WLXAXMLP_UFFICIO.getString(_byteBuffer);
		}
		return wlxaxmlpUfficio;
	}

	public void setWlxaxmlpUfficio(String wlxaxmlpUfficio) {
		if (WLXAXMLP_UFFICIO.equals(this.wlxaxmlpUfficio, wlxaxmlpUfficio)) {
			return;
		}
		WLXAXMLP_UFFICIO.putString(wlxaxmlpUfficio, _byteBuffer);
		this.wlxaxmlpUfficio = wlxaxmlpUfficio;
	}

	public String getWlxaxmlpSezione() {
		if (wlxaxmlpSezione == null) {
			wlxaxmlpSezione = WLXAXMLP_SEZIONE.getString(_byteBuffer);
		}
		return wlxaxmlpSezione;
	}

	public void setWlxaxmlpSezione(String wlxaxmlpSezione) {
		if (WLXAXMLP_SEZIONE.equals(this.wlxaxmlpSezione, wlxaxmlpSezione)) {
			return;
		}
		WLXAXMLP_SEZIONE.putString(wlxaxmlpSezione, _byteBuffer);
		this.wlxaxmlpSezione = wlxaxmlpSezione;
	}

	public String getWlxaxmlpTerm() {
		if (wlxaxmlpTerm == null) {
			wlxaxmlpTerm = WLXAXMLP_TERM.getString(_byteBuffer);
		}
		return wlxaxmlpTerm;
	}

	public void setWlxaxmlpTerm(String wlxaxmlpTerm) {
		if (WLXAXMLP_TERM.equals(this.wlxaxmlpTerm, wlxaxmlpTerm)) {
			return;
		}
		WLXAXMLP_TERM.putString(wlxaxmlpTerm, _byteBuffer);
		this.wlxaxmlpTerm = wlxaxmlpTerm;
	}

	public String getWlxaxmlpOpe() {
		if (wlxaxmlpOpe == null) {
			wlxaxmlpOpe = WLXAXMLP_OPE.getString(_byteBuffer);
		}
		return wlxaxmlpOpe;
	}

	public void setWlxaxmlpOpe(String wlxaxmlpOpe) {
		if (WLXAXMLP_OPE.equals(this.wlxaxmlpOpe, wlxaxmlpOpe)) {
			return;
		}
		WLXAXMLP_OPE.putString(wlxaxmlpOpe, _byteBuffer);
		this.wlxaxmlpOpe = wlxaxmlpOpe;
	}

	public int getWlxaxmlpDat() {
		if (wlxaxmlpDat == null) {
			wlxaxmlpDat = new Integer(WLXAXMLP_DAT.getInt(_byteBuffer));
		}
		return wlxaxmlpDat.intValue();
	}

	public void setWlxaxmlpDat(int wlxaxmlpDat) {
		if (WLXAXMLP_DAT.equals(this.wlxaxmlpDat, wlxaxmlpDat)) {
			return;
		}
		WLXAXMLP_DAT.putInt(wlxaxmlpDat, _byteBuffer);
		this.wlxaxmlpDat = new Integer(wlxaxmlpDat);
	}

	public int getWlxaxmlpOra() {
		if (wlxaxmlpOra == null) {
			wlxaxmlpOra = new Integer(WLXAXMLP_ORA.getInt(_byteBuffer));
		}
		return wlxaxmlpOra.intValue();
	}

	public void setWlxaxmlpOra(int wlxaxmlpOra) {
		if (WLXAXMLP_ORA.equals(this.wlxaxmlpOra, wlxaxmlpOra)) {
			return;
		}
		WLXAXMLP_ORA.putInt(wlxaxmlpOra, _byteBuffer);
		this.wlxaxmlpOra = new Integer(wlxaxmlpOra);
	}

	public String getWlxaxmlpEnteCont() {
		if (wlxaxmlpEnteCont == null) {
			wlxaxmlpEnteCont = WLXAXMLP_ENTE_CONT.getString(_byteBuffer);
		}
		return wlxaxmlpEnteCont;
	}

	public void setWlxaxmlpEnteCont(String wlxaxmlpEnteCont) {
		if (WLXAXMLP_ENTE_CONT.equals(this.wlxaxmlpEnteCont, wlxaxmlpEnteCont)) {
			return;
		}
		WLXAXMLP_ENTE_CONT.putString(wlxaxmlpEnteCont, _byteBuffer);
		this.wlxaxmlpEnteCont = wlxaxmlpEnteCont;
	}

	public String getWlxaxmlpTipEnteCont() {
		if (wlxaxmlpTipEnteCont == null) {
			wlxaxmlpTipEnteCont = WLXAXMLP_TIP_ENTE_CONT.getString(_byteBuffer);
		}
		return wlxaxmlpTipEnteCont;
	}

	public void setWlxaxmlpTipEnteCont(String wlxaxmlpTipEnteCont) {
		if (WLXAXMLP_TIP_ENTE_CONT.equals(this.wlxaxmlpTipEnteCont, wlxaxmlpTipEnteCont)) {
			return;
		}
		WLXAXMLP_TIP_ENTE_CONT.putString(wlxaxmlpTipEnteCont, _byteBuffer);
		this.wlxaxmlpTipEnteCont = wlxaxmlpTipEnteCont;
	}

	public String getWlxaxmlpSubEnteCont() {
		if (wlxaxmlpSubEnteCont == null) {
			wlxaxmlpSubEnteCont = WLXAXMLP_SUB_ENTE_CONT.getString(_byteBuffer);
		}
		return wlxaxmlpSubEnteCont;
	}

	public void setWlxaxmlpSubEnteCont(String wlxaxmlpSubEnteCont) {
		if (WLXAXMLP_SUB_ENTE_CONT.equals(this.wlxaxmlpSubEnteCont, wlxaxmlpSubEnteCont)) {
			return;
		}
		WLXAXMLP_SUB_ENTE_CONT.putString(wlxaxmlpSubEnteCont, _byteBuffer);
		this.wlxaxmlpSubEnteCont = wlxaxmlpSubEnteCont;
	}

	public String getWlxaxmlpCabCont() {
		if (wlxaxmlpCabCont == null) {
			wlxaxmlpCabCont = WLXAXMLP_CAB_CONT.getString(_byteBuffer);
		}
		return wlxaxmlpCabCont;
	}

	public void setWlxaxmlpCabCont(String wlxaxmlpCabCont) {
		if (WLXAXMLP_CAB_CONT.equals(this.wlxaxmlpCabCont, wlxaxmlpCabCont)) {
			return;
		}
		WLXAXMLP_CAB_CONT.putString(wlxaxmlpCabCont, _byteBuffer);
		this.wlxaxmlpCabCont = wlxaxmlpCabCont;
	}

	public int getWlxaxmlpDatContabile() {
		if (wlxaxmlpDatContabile == null) {
			wlxaxmlpDatContabile = new Integer(WLXAXMLP_DAT_CONTABILE.getInt(_byteBuffer));
		}
		return wlxaxmlpDatContabile.intValue();
	}

	public void setWlxaxmlpDatContabile(int wlxaxmlpDatContabile) {
		if (WLXAXMLP_DAT_CONTABILE.equals(this.wlxaxmlpDatContabile, wlxaxmlpDatContabile)) {
			return;
		}
		WLXAXMLP_DAT_CONTABILE.putInt(wlxaxmlpDatContabile, _byteBuffer);
		this.wlxaxmlpDatContabile = new Integer(wlxaxmlpDatContabile);
	}

	public String getCodTipExpe() {
		if (codTipExpe == null) {
			codTipExpe = COD_TIP_EXPE.getString(_byteBuffer);
		}
		return codTipExpe;
	}

	public void setCodTipExpe(String codTipExpe) {
		if (COD_TIP_EXPE.equals(this.codTipExpe, codTipExpe)) {
			return;
		}
		COD_TIP_EXPE.putString(codTipExpe, _byteBuffer);
		this.codTipExpe = codTipExpe;
	}

	public int getNumCtaInt() {
		if (numCtaInt == null) {
			numCtaInt = new Integer(NUM_CTA_INT.getInt(_byteBuffer));
		}
		return numCtaInt.intValue();
	}

	public void setNumCtaInt(int numCtaInt) {
		if (NUM_CTA_INT.equals(this.numCtaInt, numCtaInt)) {
			return;
		}
		NUM_CTA_INT.putInt(numCtaInt, _byteBuffer);
		this.numCtaInt = new Integer(numCtaInt);
	}

	public String getCodEmpresa() {
		if (codEmpresa == null) {
			codEmpresa = COD_EMPRESA.getString(_byteBuffer);
		}
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		if (COD_EMPRESA.equals(this.codEmpresa, codEmpresa)) {
			return;
		}
		COD_EMPRESA.putString(codEmpresa, _byteBuffer);
		this.codEmpresa = codEmpresa;
	}

}
