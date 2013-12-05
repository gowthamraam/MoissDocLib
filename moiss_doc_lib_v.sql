-- =========================================================================
-- $Header$
--
-- Name                               : moiss_doc_lib_v.sql
--
-- Description     :   Table Creation Scripts for  Moiss Document Library
--
--
-- Who                                                      Remarks                                    Date
-- --------------                           ---------------------------------------   -----------------
-- Gowtham Raam.J -4iApps     1.0 - Initial Version                        12-Nov-2013
-- =========================================================================


CREATE OR REPLACE FORCE VIEW APPS.MOISS_DOC_LIBRARY_V
(
   ROW_ID,
   DOC_ID,
   DOCUMENT_NAME,
   DOCUMENT_FILE,
   OWNING_DEPT,
   OWNING_DEPT_DESC,
   CATEGORY,
   CATEGORY_DESC,
   DOCUMENT_NUMBER,
   VERSION_NUMBER,
   EFFECTIVE_START_DATE,
   EFFECTIVE_END_DATE,
   MUST_READ,
   ATTRIBUTE_CATEGORY,
   ATTRIBUTE1,
   ATTRIBUTE2,
   ATTRIBUTE3,
   ATTRIBUTE4,
   ATTRIBUTE5,
   ATTRIBUTE6,
   ATTRIBUTE7,
   ATTRIBUTE8,
   ATTRIBUTE9,
   ATTRIBUTE10,
   CREATED_BY,
   CREATION_DATE,
   LAST_UPDATED_BY,
   LAST_UPDATE_DATE,
   LAST_UPDATE_LOGIN
)
AS
   SELECT   XDL.ROWID,
            XDL.DOC_ID,
            XDL.DOCUMENT_NAME,
            XDL.DOCUMENT_FILE,
            XDL.OWNING_DEPT,
            FCL1.MEANING OWNING_DEPT_DESC,
            XDL.CATEGORY,
            FCL2.MEANING CATEGORY_DESC,
            XDL.DOCUMENT_NUMBER,
            XDL.VERSION_NUMBER,
            TO_CHAR (XDL.EFFECTIVE_START_DATE, 'DD-Mon-YYYY'),
            TO_CHAR (XDL.EFFECTIVE_END_DATE, 'DD-Mon-YYYY'),
            XDL.MUST_READ,
            XDL.ATTRIBUTE_CATEGORY,
           
            XDL.ATTRIBUTE1,
            XDL.ATTRIBUTE2,
            XDL.ATTRIBUTE3,
            XDL.ATTRIBUTE4,
            XDL.ATTRIBUTE5,
            XDL.ATTRIBUTE6,
            XDL.ATTRIBUTE7,
            XDL.ATTRIBUTE8,
            XDL.ATTRIBUTE9,
            XDL.ATTRIBUTE10,
            XDL.CREATED_BY,
            XDL.CREATION_DATE,
            XDL.LAST_UPDATED_BY,
            XDL.LAST_UPDATE_DATE,
            XDL.LAST_UPDATE_LOGIN
     FROM   MOISS_DOC_LIBRARY XDL,
            FND_LOOKUP_VALUES FCL1,
            FND_LOOKUP_VALUES FCL2
    WHERE       FCL1.LOOKUP_TYPE = 'MOISS_DOC_DEPTS'
            AND FCL1.LOOKUP_CODE = XDL.OWNING_DEPT
            AND FCL2.LOOKUP_TYPE = 'MOISS_DOC_CATEGORY'
            AND FCL2.LOOKUP_CODE = XDL.CATEGORY
            AND FCL1.ENABLED_FLAG = 'Y'
            AND FCL2.ENABLED_FLAG = 'Y'
            AND SYSDATE >= NVL (FCL1.START_DATE_ACTIVE, FCL1.CREATION_DATE)
            AND SYSDATE <= NVL (FCL1.END_DATE_ACTIVE, '31-DEC-2999')
            AND SYSDATE >= NVL (FCL2.START_DATE_ACTIVE, FCL2.CREATION_DATE)
            AND SYSDATE <= NVL (FCL2.END_DATE_ACTIVE, '31-DEC-2999');


CREATE VIEW MOISS_DOC_LIBRARY_USER_V(
ROW_ID,
USER_DOC_ID,
      DOC_ID,
      USER_ID,
      USER_NAME,				--User Name for Modification
      READ_ACCEPT_FLAG,
      ATTRIBUTE_CATEGORY,
      ATTRIBUTE1,
      ATTRIBUTE2,
      ATTRIBUTE3,
      ATTRIBUTE4,
      ATTRIBUTE5,
      ATTRIBUTE6,
      ATTRIBUTE7,
      ATTRIBUTE8,
      ATTRIBUTE9,
      ATTRIBUTE10, 
      CREATED_BY,
      CREATION_DATE,
      LAST_UPDATED_BY,
      LAST_UPDATE_DATE,
      LAST_UPDATE_LOGIN) AS
 SELECT
XDLU.ROWID,
XDLU.USER_DOC_ID,
XDLU.DOC_ID,
      XDLU.USER_ID,
FU.USER_NAME,
      XDLU.READ_ACCEPT_FLAG,
      XDLU.ATTRIBUTE_CATEGORY,
      XDLU.ATTRIBUTE1,
      XDLU.ATTRIBUTE2,
      XDLU.ATTRIBUTE3,
      XDLU.ATTRIBUTE4,
      XDLU.ATTRIBUTE5,
      XDLU.ATTRIBUTE6,
      XDLU.ATTRIBUTE7,
      XDLU.ATTRIBUTE8,
      XDLU.ATTRIBUTE9,
      XDLU.ATTRIBUTE10,     
      XDLU.CREATED_BY,
      XDLU.CREATION_DATE,
      XDLU.LAST_UPDATED_BY,
      XDLU.LAST_UPDATE_DATE,
      XDLU.LAST_UPDATE_LOGIN  
FROM MOISS_DOC_LIBRARY_USER  XDLU,             
FND_USER     FU
WHERE FU.USER_ID=XDLU.USER_ID ;
      




