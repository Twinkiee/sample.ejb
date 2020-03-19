package com.sample.ejb;

import static javax.ejb.TransactionAttributeType.MANDATORY;

import com.sample.ejb.api.RemoteExecutorEjb;
import com.sample.ejb.bean.CT10002XCommareaWrapper1;
import com.sample.ejb.bean.CT30024XCommareaWrapper1;
import com.sample.ejb.api.Was2CicsEjb;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
@Remote(EquinixCts30024Ejb03.class)
public class EquinixCts30024Ejb03 implements RemoteExecutorEjb {

  public static final int ON_LINE = 0;
  public static final int BATCH = 1;
  public static final int REUTIL_ON = 2;

  private static final Logger logger = LoggerFactory.getLogger(EquinixCts30024Ejb03.class);

  @Resource
  private DataSource dataSource;

  @EJB(lookup = "was2CicsEjb")
  private Was2CicsEjb was2Cics;

  @Override
  @TransactionAttribute(MANDATORY)
  public byte[] execute(byte[] input) {
    logger.info("Executing remote EJB");

    CT30024XCommareaWrapper1 ct30024XCommareaWrapper1 = new CT30024XCommareaWrapper1(input);

    try (Connection connection = dataSource.getConnection()) {

      logger.info("Default schema [ {} ]", dataSource.getConnection().getSchema());

      logger.info("Calling CICS module 'EC01' (Timestamp)");
      long time = System.nanoTime();
      final String timestamp = getTimestamp();
      logger.info("CICS module 'EC01' called in [ {} ] ns; returned timestamp [ {} ]", System.nanoTime() - time, timestamp);

      logger.info("Calling CICS module 'A2121-OBTENER-SALDO'");
      time = System.nanoTime();
      final BigDecimal saldo = retrieveSaldo(ct30024XCommareaWrapper1);
      logger.info("CICS module 'A2121-OBTENER-SALDO' called in [ {} ] ns", System.nanoTime() - time);

      ct30024XCommareaWrapper1.setSaldo(saldo);

      time = System.nanoTime();
      doUpdate(connection, ct30024XCommareaWrapper1, timestamp);
      logger.info("Remote EJB update executed in [ {} ] ns", System.nanoTime() - time);

    } catch (SQLException e) {

      logger.error("Error while executing the remote EJB", e);
      throw new EJBException(e);
    }

    return ct30024XCommareaWrapper1.getByteBuffer();
  }

  private String getTimestamp() {
    try {
      return new String(was2Cics.driveIntoCics("CICSREG", "EC01", new byte [18]), "Cp1047");
    } catch (UnsupportedEncodingException e) {
      logger.error("An error occurred when encoding timestamp module (EC01) return value", e);
      throw new EJBException(e);
    }
  }

  // TODO Complete implementation with returning value
  private BigDecimal retrieveSaldo(CT30024XCommareaWrapper1 ct30024XCommareaWrapper1) {

    final CT10002XCommareaWrapper1 ct10002XCommareaWrapper1 = new CT10002XCommareaWrapper1();

//      *-- LETTURA DEL SALDO DEL CONTO CON SERVIZIO CTS10002
//           MOVE COD-TIP-EXPE OF TL-T08CT006     OF INPUT-TXN
//             TO COD-TIP-EXPE OF RES-MEN-CT1002I OF INPUT-TXN-10102
//
//           MOVE NUM-CTA-INT  OF TL-T08CT006     OF INPUT-TXN
//             TO NUM-CTA-INT  OF RES-MEN-CT1002I OF INPUT-TXN-10102
//
//           MOVE COD-EMPRESA  OF TL-T08CT006     OF INPUT-TXN
//             TO COD-EMPRESA  OF RES-MEN-CT1002I OF INPUT-TXN-10102
//
//           &AQENVIAR(1010,2)
//           IF FNDSEVEREERRORCODE NOT EQUAL TO FND-SEVERITY-OK THEN
//ERRMAK        MOVE 'A2121-OBTENER-SALDO 13' TO LOG-APPL-DATA
//              &AQERROR(ERROR,FNDERRORMSGNUM,CT0009P)
//           END-IF.
//
//           MOVE SALCONTABLE OF OUTPUT-TXN-10102
//             TO WS-SALDO.

    ct10002XCommareaWrapper1.setCodTipExpe(ct30024XCommareaWrapper1.getCodTipExpe());
    ct10002XCommareaWrapper1.setNumCtaInt(ct30024XCommareaWrapper1.getNumCtaInt());
    ct10002XCommareaWrapper1.setCodEmpresa(ct30024XCommareaWrapper1.getCodEmpresa());

    was2Cics.driveIntoCics("CICSREG", "CTS10002", ct10002XCommareaWrapper1.getByteBuffer());

    return BigDecimal.TEN;
  }


  private void doUpdate(Connection connection,
      CT30024XCommareaWrapper1 wrapper, String timestamp) throws SQLException {

//          *--- DATOS DE ARQUITECTURA - GLOBALES
//          *--- ARCHITECTURE DATA - GLOBALS
//
//          **CT2001N1 BEGIN
//          ** LA DATA CONTABILE VIENE VALORIZZATA DAL CHIAMANTE
//               IF FEC-CONTABLE OF MSGINSMOVE = SPACES
//                  MOVE AQBF-FEM-CONTABLE  TO FEC-CONTABLE OF T08CT006
//                 ELSE
//                  MOVE FEC-CONTABLE OF MSGINSMOVE
//                                          TO FEC-CONTABLE OF T08CT006
//               END-IF.
    if (wrapper.getFecContable() == null || wrapper.getFecContable().isEmpty()) {
      wrapper.setFecContable(wrapper.getAqbfFemContable());
    }

//    990329** LA DATA OPERAZIONE VIENE VALORIZZATA DAL CHIAMANTE
//    990329     IF FEC-OPERACION OF MSGINSMOVE = SPACES
//    990329         MOVE AQBF-FEM-OPERACION TO FEC-OPERACION OF T08CT006
//    990329        ELSE
//    990329         MOVE FEC-OPERACION OF MSGINSMOVE
//    990329                                 TO FEC-OPERACION OF T08CT006
//    990329     END-IF.
    if (wrapper.getFecOperacion() == null || wrapper.getFecOperacion().isEmpty()) {
      wrapper.setFecOperacion(wrapper.getAqbfFemOperacion());
    }

//    990329*    MOVE AQBF-FEM-OPERACION TO FEC-OPERACION   OF T08CT006
//               MOVE AQBF-COD-USUARIO   TO COD-USU-ALTA    OF T08CT006
//                                          COD-USU-MODIF   OF T08CT006.
    wrapper.setCodUsuAlta(wrapper.getAqbfCodUsuario());
    wrapper.setCodUsuModif(wrapper.getAqbfCodUsuario());

//    980714     IF  BATCH OF AQBF-IND-ON-BATCH
//    980714         MOVE COD-CENT-ORIG OF INPUT-TXN
//    980714                                 TO COD-CENT-ORIG   OF T08CT006
//    980714     ELSE
//    980714         MOVE AQBF-COD-CENTRO    TO COD-CENT-ORIG  OF T08CT006
//    980714     END-IF.
    if (wrapper.getAqbfIndOnBatch() != BATCH) {
      wrapper.setCodCentOrig(wrapper.getAqbfCodCentro());
    }

//               MOVE AQBF-COD-DOMINIO   TO COD-DOMINIO     OF T08CT006
    wrapper.setCodDominio(wrapper.getAqbfCodDominio());
//               MOVE AQBF-NUM-NODO      TO NUM-NODO        OF T08CT006
    wrapper.setNumNodo(wrapper.getAqbfNumNodo());
//               MOVE AQBF-NUM-ULT       TO NUM-OPERACION   OF T08CT006
    wrapper.setNumOperacion(wrapper.getAqbfNumUlt());
//          * 10DS1095 - INIZIO
//          *    MOVE AQBF-COD-OPER-ENC  TO NUM-OPER-ENLAZA OF T08CT006
//               MOVE NUM-OPER-ENLAZA OF INPUT-TXN
//                                       TO NUM-OPER-ENLAZA OF T08CT006
    wrapper.setNumOperEnlaza(wrapper.getNumOperEnlaza());
//          * 10DS1095 - FINE
//    980604     MOVE AQBF-NUM-DE-PUESTO TO NUM-DE-PUESTO   OF T08CT006.
    wrapper.setNumDePuesto(wrapper.getAqbfNumDePuesto());
//          **CT2002N1 END
//
//      *--- INDICADOR DE OPERACION ENCADENADA
//      *--- INDICATOR OF CHAINED OPERATION
//      **   IF AQBF-COD-OPER-ENC > 0 THEN
//      *------ SI ENCADENADA
//      *------ IT IS CHAINED
//      **      MOVE '1' TO IND-OPER-ENLAZADA OF T08CT006
//      **   ELSE
//      *------ NO ENCADENADA
//      *------ IT IS NOT CHAINED
//      **      MOVE '0' TO IND-OPER-ENLAZADA OF T08CT006
//      **   END-IF
//      ********* MODIFICA DI IND-OPER-ENLAZADA E' UN INDICATORE
//      ********* CHE DICE SE IL MOVIMETNO E' STATO GIRATO SU UN
//      ********* UN ALTRO CONTO
//           IF IND-OPER-ENLAZADA OF INPUT-TXN = SPACE
//              MOVE '0' TO IND-OPER-ENLAZADA OF T08CT006
//           ELSE
//              MOVE  IND-OPER-ENLAZADA OF INPUT-TXN
//                                     TO IND-OPER-ENLAZADA OF T08CT006
//           END-IF.

    if (wrapper.getIndOperEnlazada() == null || wrapper.getIndOperEnlazada().isEmpty()) {
      wrapper.setIndOperEnlazada("0");
    }
//
//           MOVE '01.01.0001'         TO  FEC-MODIFICACION OF T08CT006
    wrapper.setFecModificacion("01.01.0001");

//           MOVE NUM-CTA-INT    OF MSGINSMOVE TO WS-NUM-CTA-INT
//           MOVE COD-TIP-EXPE   OF MSGINSMOVE TO WS-COD-TIP-EXPE
//           MOVE COD-EMPRESA    OF MSGINSMOVE TO WS-COD-EMPRESA
//           MOVE IND-NATURALEZA OF MSGINSMOVE TO WS-NATURALEZA
//           MOVE 0                            TO WS-SALDO.
//
//      *CT2003N1-INIZIO
//           MOVE  ZERO TO IND-EXTRA-ENVI OF T08CT006.
//      *CT2003N1-FINE
//      *--- RPM2003 - 15/12/94
//      *--- OBTENER ULTIMO SALDO
//      *--- OBTAINING LAST BALANCE
//           PERFORM A2121-OBTENER-SALDO.
//
//      *    EXEC SQL
//      *         SELECT SAL_DESOPER
//      *         INTO :WS-SALDO
//      *         FROM T08CT006
//      *         WHERE NUM_CTA_INT    = :WS-NUM-CTA-INT    AND
//      *               COD_TIP_EXPE   = :WS-COD-TIP-EXPE   AND
//      *               COD_EMPRESA    = :WS-COD-EMPRESA    AND
//      *               TIMESTAMP_ALTA = ( SELECT MAX(TIMESTAMP_ALTA)
//      *                                  FROM T08CT006
//      *                                  WHERE NUM_CTA_INT =
//      *                                             :WS-NUM-CTA-INT  AND
//      *                                        COD_TIP_EXPE =
//      *                                             :WS-COD-TIP-EXPE AND
//      *                                        COD_EMPRESA  =
//      *                                             :WS-COD-EMPRESA )
//      *    END-EXEC.
//
//ERRMAK     MOVE 'A2120-INSERTAR-REGISTRO: 9 ' TO LOG-APPL-DATA
//ROLLBK     MOVE 'Y' TO FLAG-ROLLBACK OF PABHI
//           EXEC SQL
//                INSERT
//                INTO T08CT006
//                     (COD_TIP_EXPE            ,
//                      NUM_CTA_INT             ,
//                      COD_EMPRESA             ,
//                      FEC_OPERACION           ,
//                      TIMESTAMP_ALTA          ,
//                      COD_OPERACION           ,
//                      COD_REFER               ,
//                      DEC_REF_AMPLIADA        ,
//                      IMP_MOVIMIENTO          ,
//                      IND_NATURALEZA          ,
//                      FEC_CONTABLE            ,
//                      FEC_VALOR               ,
//                      SAL_DESOPER             ,
//                      TXT_MOVIMIENTO          ,
//                      NUM_OPERACION           ,
//                      NUM_OPER_ENLAZA         ,
//                      IND_OPER_ENLAZADA       ,
//                      IND_PTE_LIBRETA         ,
//                      IND_EXTRA_ENVI          ,
//                      NUMERO_DOCUMENTO        ,
//                      IND_MOVAN               ,
//                      IND_CONDO               ,
//                      IND_ORIGEN_MOV          ,
//                      IND_SOPORTE             ,
//                      COD_TIPO_INTERVEN       ,
//                      NOMBRE                  ,
//                      COD_IDENTIFICA          ,
//                      FEC_VENCIMIENTO         ,
//                      COD_ENT_CP              ,
//                      COD_SUC_CP              ,
//                      COD_DIG_CONTROLCP       ,
//                      NUM_CUENTA_CP           ,
//                      FECHA_INICIO            ,
//                      FEC_MODIFICACION        ,
//                      COD_USU_ALTA            ,
//                      COD_CENT_ORIG           ,
//                      COD_DESFI               ,
//                      NUM_CTA_CONT            ,
//                      COD_REFERENCIA_OPE      ,
//                      IND_TRUNC               ,
//                      COD_NUM_DOC_OFICIA      ,
//                      COD_ESTSI               ,
//                      COD_PAIS                ,
//                      NUM_IMPOSICION          ,
//                      SAL_ACTUAL              ,
//                      TIMESTAMP_SIGLO         ,
//                      COD_USU_MODIF           ,
//                      COD_DOMINIO             ,
//                      NUM_NODO                ,
//                      IND_MOD_TABLA           ,
//      **CT2001N1 BEGIN
//                      NUM_MOVIMENTO           ,
//                      IMP_ORIGINARIO          ,
//                      COD_MONEDA_ORIG         ,
//                      IMP_CONTA               ,
//                      IMP_COMMISSIONI         ,
//                      IMP_SPESE               ,
//                      IMP_SPESE_RECLAM        ,
//                      COD_GRUPPO_SPESA        ,
//                      FEC_DISPONIBILITA       ,
//                      IND_INVIO_CONTAB        ,
//                      IND_MOVST               ,
//                      IND_MOVFOR_VAL          ,
//                      IND_MOVFOR_SCO          ,
//                      IND_MOVFOR_BLO          ,
//                      IND_MOVFOR_IMP          ,
//                      IND_MOVFOR_RIS          ,
//                      COD_CHECK               ,
//                      NUM_REL_CLIENTE         ,
//                      NUM_MOVST               ,
//                      NUM_DE_PUESTO           ,
//                      TIP_DISPONIBILITA       ,
//                      TIP_LIQUIDITA           ,
//                      COD_CANALE              ,
//                      COD_PROC_ORIG )
//      **CT2001N1 END
//                VALUES (:T08CT006.COD-TIP-EXPE            ,
//                        :T08CT006.NUM-CTA-INT             ,
//                        :T08CT006.COD-EMPRESA             ,
//                        :T08CT006.FEC-OPERACION           ,
//                        CURRENT TIMESTAMP                 ,
//                        :T08CT006.COD-OPERACION           ,
//                        :T08CT006.COD-REFER               ,
//                        :T08CT006.DEC-REF-AMPLIADA        ,
//                        :T08CT006.IMP-MOVIMIENTO          ,
//                        :T08CT006.IND-NATURALEZA          ,
//                        :T08CT006.FEC-CONTABLE            ,
//                        :T08CT006.FEC-VALOR               ,
//                        :WS-SALDO                         ,
//                        :T08CT006.TXT-MOVIMIENTO          ,
//                        :T08CT006.NUM-OPERACION           ,
//                        :T08CT006.NUM-OPER-ENLAZA         ,
//                        :T08CT006.IND-OPER-ENLAZADA       ,
//                        :T08CT006.IND-PTE-LIBRETA         ,
//                        :T08CT006.IND-EXTRA-ENVI          ,
//                        :T08CT006.NUMERO-DOCUMENTO        ,
//                        :T08CT006.IND-MOVAN               ,
//                        :T08CT006.IND-CONDO               ,
//                        :T08CT006.IND-ORIGEN-MOV          ,
//                        :T08CT006.IND-SOPORTE             ,
//                        :T08CT006.COD-TIPO-INTERVEN       ,
//                        :T08CT006.NOMBRE                  ,
//                        :T08CT006.COD-IDENTIFICA          ,
//                        :T08CT006.FEC-VENCIMIENTO         ,
//                        :T08CT006.COD-ENT-CP              ,
//                        :T08CT006.COD-SUC-CP              ,
//                        :T08CT006.COD-DIG-CONTROLCP       ,
//                        :T08CT006.NUM-CUENTA-CP           ,
//                        :T08CT006.FECHA-INICIO            ,
//                        :T08CT006.FEC-MODIFICACION        ,
//                        :T08CT006.COD-USU-ALTA            ,
//                        :T08CT006.COD-CENT-ORIG           ,
//                        :T08CT006.COD-DESFI               ,
//                        :T08CT006.NUM-CTA-CONT            ,
//                        :T08CT006.COD-REFERENCIA-OPE      ,
//                        :T08CT006.IND-TRUNC               ,
//                        :T08CT006.COD-NUM-DOC-OFICIA      ,
//                        :T08CT006.COD-ESTSI               ,
//                        :T08CT006.COD-PAIS                ,
//                        :T08CT006.NUM-IMPOSICION          ,
//                        :T08CT006.SAL-ACTUAL              ,
//                        CURRENT TIMESTAMP                 ,
//                        :T08CT006.COD-USU-MODIF           ,
//                        :T08CT006.COD-DOMINIO             ,
//                        :T08CT006.NUM-NODO                ,
//                        :T08CT006.IND-MOD-TABLA           ,
//      **CT2001N1 BEGIN
//                        :T08CT006.NUM-MOVIMENTO           ,
//                        :T08CT006.IMP-ORIGINARIO          ,
//                        :T08CT006.COD-MONEDA-ORIG         ,
//                        :T08CT006.IMP-CONTA               ,
//                        :T08CT006.IMP-COMMISSIONI        ,
//                        :T08CT006.IMP-SPESE              ,
//                        :T08CT006.IMP-SPESE-RECLAM       ,
//                        :T08CT006.COD-GRUPPO-SPESA       ,
//                        :T08CT006.FEC-DISPONIBILITA      ,
//                        :T08CT006.IND-INVIO-CONTAB       ,
//                        :T08CT006.IND-MOVST              ,
//                        :T08CT006.IND-MOVFOR-VAL         ,
//                        :T08CT006.IND-MOVFOR-SCO         ,
//                        :T08CT006.IND-MOVFOR-BLO         ,
//                        :T08CT006.IND-MOVFOR-IMP         ,
//                        :T08CT006.IND-MOVFOR-RIS         ,
//                        :T08CT006.COD-CHECK              ,
//                        :T08CT006.NUM-REL-CLIENTE        ,
//                        :T08CT006.NUM-MOVST              ,
//                        :T08CT006.NUM-DE-PUESTO          ,
//                        :T08CT006.TIP-DISPONIBILITA      ,
//                        :T08CT006.TIP-LIQUIDITA          ,
//                        :T08CT006.COD-CANALE             ,
//                        :T08CT006.COD-PROC-ORIG          )
//      **CT2001N1 END
//           END-EXEC.
    String sql = "INSERT\n"
        + "                INTO T08CT006\n"
        + "                     (COD_TIP_EXPE                        ,\n"
        + "                      NUM_CTA_INT                         ,\n"
        + "                      COD_EMPRESA                         ,\n"
        + "                      FEC_OPERACION                       ,\n"
        + "                      TIMESTAMP_ALTA                      ,\n"
        + "                      COD_OPERACION                       ,\n"
        + "                      COD_REFER                           ,\n"
        + "                      DEC_REF_AMPLIADA                    ,\n"
        + "                      IMP_MOVIMIENTO                      ,\n"
        + "                      IND_NATURALEZA                      ,\n"
        + "                      FEC_CONTABLE                        ,\n"
        + "                      FEC_VALOR                           ,\n"
        + "                      SAL_DESOPER                         ,\n"
        + "                      TXT_MOVIMIENTO                      ,\n"
        + "                      NUM_OPERACION                       ,\n"
        + "                      NUM_OPER_ENLAZA                     ,\n"
        + "                      IND_OPER_ENLAZADA                   ,\n"
        + "                      IND_PTE_LIBRETA                     ,\n"
        + "                      IND_EXTRA_ENVI                      ,\n"
        + "                      NUMERO_DOCUMENTO                    ,\n"
        + "                      IND_MOVAN                           ,\n"
        + "                      IND_CONDO                           ,\n"
        + "                      IND_ORIGEN_MOV                      ,\n"
        + "                      IND_SOPORTE                         ,\n"
        + "                      COD_TIPO_INTERVEN                   ,\n"
        + "                      NOMBRE                              ,\n"
        + "                      COD_IDENTIFICA                      ,\n"
        + "                      FEC_VENCIMIENTO                     ,\n"
        + "                      COD_ENT_CP                          ,\n"
        + "                      COD_SUC_CP                          ,\n"
        + "                      COD_DIG_CONTROLCP                   ,\n"
        + "                      NUM_CUENTA_CP                       ,\n"
        + "                      FECHA_INICIO                        ,\n"
        + "                      FEC_MODIFICACION                    ,\n"
        + "                      COD_USU_ALTA                        ,\n"
        + "                      COD_CENT_ORIG                       ,\n"
        + "                      COD_DESFI                           ,\n"
        + "                      NUM_CTA_CONT                        ,\n"
        + "                      COD_REFERENCIA_OPE                  ,\n"
        + "                      IND_TRUNC                           ,\n"
        + "                      COD_NUM_DOC_OFICIA                  ,\n"
        + "                      COD_ESTSI                           ,\n"
        + "                      COD_PAIS                            ,\n"
        + "                      NUM_IMPOSICION                      ,\n"
        + "                      SAL_ACTUAL                          ,\n"
        + "                      TIMESTAMP_SIGLO                     ,\n"
        + "                      COD_USU_MODIF                       ,\n"
        + "                      COD_DOMINIO                         ,\n"
        + "                      NUM_NODO                            ,\n"
        + "                      IND_MOD_TABLA                       ,\n"
        + "                      NUM_MOVIMENTO                       ,\n"
        + "                      IMP_ORIGINARIO                      ,\n"
        + "                      COD_MONEDA_ORIG                     ,\n"
        + "                      IMP_CONTA                           ,\n"
        + "                      IMP_COMMISSIONI                     ,\n"
        + "                      IMP_SPESE                           ,\n"
        + "                      IMP_SPESE_RECLAM                    ,\n"
        + "                      COD_GRUPPO_SPESA                    ,\n"
        + "                      FEC_DISPONIBILITA                   ,\n"
        + "                      IND_INVIO_CONTAB                    ,\n"
        + "                      IND_MOVST                           ,\n"
        + "                      IND_MOVFOR_VAL                      ,\n"
        + "                      IND_MOVFOR_SCO                      ,\n"
        + "                      IND_MOVFOR_BLO                      ,\n"
        + "                      IND_MOVFOR_IMP                      ,\n"
        + "                      IND_MOVFOR_RIS                      ,\n"
        + "                      COD_CHECK                           ,\n"
        + "                      NUM_REL_CLIENTE                     ,\n"
        + "                      NUM_MOVST                           ,\n"
        + "                      NUM_DE_PUESTO                       ,\n"
        + "                      TIP_DISPONIBILITA                   ,\n"
        + "                      TIP_LIQUIDITA                       ,\n"
        + "                      COD_CANALE                          ,\n"
        + "                      COD_PROC_ORIG )                      \n"
        + "                VALUES (? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        CURRENT TIMESTAMP ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? ,\n"
        + "                        ? )";

    int i = 1;
    final PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(i++, wrapper.getCodTipExpe());
    preparedStatement.setInt(i++, wrapper.getNumCtaInt());
    preparedStatement.setString(i++, wrapper.getCodEmpresa());
    preparedStatement.setString(i++, wrapper.getFecOperacion());
    preparedStatement.setString(i++, timestamp);
    preparedStatement.setString(i++, wrapper.getCodOperacion());
    preparedStatement.setString(i++, wrapper.getCodRefer());
    preparedStatement.setString(i++, wrapper.getDecRefAmpliada());
    preparedStatement.setBigDecimal(i++, wrapper.getImpMovimiento());
    preparedStatement.setString(i++, wrapper.getIndNaturaleza());
    preparedStatement.setString(i++, wrapper.getFecContable());
    preparedStatement.setString(i++, wrapper.getFecValor());
    preparedStatement.setBigDecimal(i++, wrapper.getSaldo());
    preparedStatement.setString(i++, wrapper.getTxtMovimiento());
    preparedStatement.setLong(i++, wrapper.getNumOperacion());
    preparedStatement.setLong(i++, wrapper.getNumOperEnlaza());
    preparedStatement.setString(i++, wrapper.getIndOperEnlazada());
    preparedStatement.setString(i++, wrapper.getIndPteLibreta());
    preparedStatement.setString(i++, wrapper.getIndExtraEnvi());
    preparedStatement.setString(i++, wrapper.getNumeroDocumento());
    preparedStatement.setString(i++, wrapper.getIndMovan());
    preparedStatement.setString(i++, wrapper.getIndCondo());
    preparedStatement.setString(i++, wrapper.getIndOrigenMov());
    preparedStatement.setString(i++, wrapper.getIndSoporte());
    preparedStatement.setString(i++, wrapper.getCodTipoInterven());
    preparedStatement.setString(i++, wrapper.getNombre());
    preparedStatement.setString(i++, wrapper.getCodIdentifica());
    preparedStatement.setString(i++, wrapper.getFecVencimiento());
    preparedStatement.setString(i++, wrapper.getCodEntCp());
    preparedStatement.setInt(i++, wrapper.getCodSucCp());
    preparedStatement.setInt(i++, wrapper.getCodDigControlcp());
    preparedStatement.setLong(i++, wrapper.getNumCuentaCp());
    preparedStatement.setString(i++, wrapper.getFechaInicio());
    preparedStatement.setString(i++, wrapper.getFecModificacion());
    preparedStatement.setString(i++, wrapper.getCodUsuAlta());
    preparedStatement.setString(i++, wrapper.getCodCentOrig());
    preparedStatement.setLong(i++, wrapper.getCodDesfi());
    preparedStatement.setString(i++, wrapper.getNumCtaCont());
    preparedStatement.setString(i++, wrapper.getCodReferenciaOpe());
    preparedStatement.setString(i++, wrapper.getIndTrunc());
    preparedStatement.setString(i++, wrapper.getCodNumDocOficia());
    preparedStatement.setString(i++, wrapper.getCodEstsi());
    preparedStatement.setString(i++, wrapper.getCodPais());
    preparedStatement.setInt(i++, wrapper.getNumImposicion());
    preparedStatement.setBigDecimal(i++, wrapper.getSalActual());
    preparedStatement.setString(i++, timestamp);
    preparedStatement.setString(i++, wrapper.getCodUsuModif());
    preparedStatement.setInt(i++, wrapper.getCodDominio());
    preparedStatement.setInt(i++, wrapper.getNumNodo());
    preparedStatement.setString(i++, wrapper.getIndModTabla());
    preparedStatement.setInt(i++, wrapper.getNumMovimento());
    preparedStatement.setBigDecimal(i++, wrapper.getImpOriginario());
    preparedStatement.setString(i++, wrapper.getCodMonedaOrig());
    preparedStatement.setBigDecimal(i++, wrapper.getImpConta());
    preparedStatement.setBigDecimal(i++, wrapper.getImpCommissioni());
    preparedStatement.setBigDecimal(i++, wrapper.getImpSpese());
    preparedStatement.setBigDecimal(i++, wrapper.getImpSpeseReclam());
    preparedStatement.setString(i++, wrapper.getCodGruppoSpesa());
    preparedStatement.setString(i++, wrapper.getFecDisponibilita());
    preparedStatement.setString(i++, wrapper.getIndInvioContab());
    preparedStatement.setString(i++, wrapper.getIndMovst());
    preparedStatement.setString(i++, wrapper.getIndMovforVal());
    preparedStatement.setString(i++, wrapper.getIndMovforSco());
    preparedStatement.setString(i++, wrapper.getIndMovforBlo());
    preparedStatement.setString(i++, wrapper.getIndMovforImp());
    preparedStatement.setString(i++, wrapper.getIndMovforRis());
    preparedStatement.setString(i++, wrapper.getCodCheck());
    preparedStatement.setLong(i++, wrapper.getNumRelCliente());
    preparedStatement.setInt(i++, wrapper.getNumMovst());
    preparedStatement.setInt(i++, wrapper.getNumDePuesto());
    preparedStatement.setString(i++, wrapper.getTipDisponibilita());
    preparedStatement.setString(i++, wrapper.getTipLiquidita());
    preparedStatement.setString(i++, wrapper.getCodCanale());
    preparedStatement.setString(i, wrapper.getCodProcOrig());
    preparedStatement.executeUpdate();
  }

//  private void doSelect(Connection connection) throws SQLException {
//    String sql = "select * from T99TERM1 where cicsname = '1233' and banca = '$999' WITH CS";
//
//    Statement stmt = connection.createStatement();
//
//    ResultSet rs = stmt.executeQuery(sql);
//
//    while (rs.next()) {
//      logger.info("Value 1 [ {} ]", rs.getObject(1));
//      logger.info("Value 2 [ {} ]", rs.getObject(2));
//    }
//  }
}
