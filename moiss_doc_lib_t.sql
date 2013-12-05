-- =========================================================================
-- $Header$
--
-- Name                               : moiss_doc_lib_t.sql
--
-- Description     : Table Creation Scripts for  Moiss Document Library
--
--
-- Who                                            Remarks                                 Date
-- --------------                           --------------------------------------- -----------------
-- Gowtham Raam.J -4iApps     1.0 - Initial Version                   12-Nov-2013
-- =========================================================================
/*TABLE -1     :     VIEW DOCUMENT  */

CREATE TABLE MOISS_DOC_LIBRARY
(
   DOC_ID           		 	  NUMBER 	NOT NULL,
   DOCUMENT_NAME    		  VARCHAR2 (60) 	NOT NULL,
   DOCUMENT_FILE       		  BLOB,
   OWNING_DEPT       		  VARCHAR2 (30),
   CATEGORY   		  	VARCHAR2 (30),
   DOCUMENT_NUMBER   		  VARCHAR2(60),
   VERSION_NUMBER    		  VARCHAR2(60),
   EFFECTIVE_START_DATE       			  DATE,
   EFFECTIVE_END_DATE           		  	DATE,
   MUST_READ                VARCHAR2 (1),
  ATTRIBUTE_CATEGORY  		VARCHAR2 (240),
  ATTRIBUTE1     	                   VARCHAR2 (240),
  ATTRIBUTE2                                VARCHAR2 (240),
  ATTRIBUTE3           		VARCHAR2 (240),
  ATTRIBUTE4         		VARCHAR2 (240),
  ATTRIBUTE5         		VARCHAR2 (240),
  ATTRIBUTE6        		VARCHAR2 (240),
  ATTRIBUTE7       		VARCHAR2 (240),
  ATTRIBUTE8      		VARCHAR2 (240),
  ATTRIBUTE9      		VARCHAR2 (240),
  ATTRIBUTE10  		VARCHAR2 (240), 
   CREATED_BY        		  NUMBER	NOT NULL,
   CREATION_DATE    		  DATE 		NOT NULL,
   LAST_UPDATED_BY 		  NUMBER 	NOT NULL,
   LAST_UPDATE_DATE 		  DATE 		NOT NULL,
   LAST_UPDATE_LOGIN  		  NUMBER
);


ALTER TABLE MOISS_DOC_LIBRARY ADD 
CONSTRAINT MOISS_DOC_LIBRARY_PK PRIMARY KEY (DOC_ID) USING INDEX;

CREATE INDEX MOISS_DOC_LIBRARY_IDX01
   ON MOISS_DOC_LIBRARY(DOCUMENT_NAME);





--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------




/* TABLE -2     :     USER VIEW DOCUMENT */


CREATE TABLE APPS.MOISS_DOC_LIBRARY_USER
(
  USER_DOC_ID         NUMBER                    NOT NULL,
  DOC_ID              NUMBER                    NOT NULL,
  USER_ID             NUMBER,
  READ_ACCEPT_FLAG    VARCHAR2(1 BYTE),
  ATTRIBUTE_CATEGORY  VARCHAR2(240 BYTE),
  ATTRIBUTE1          VARCHAR2(240 BYTE),
  ATTRIBUTE2          VARCHAR2(240 BYTE),
  ATTRIBUTE3          VARCHAR2(240 BYTE),
  ATTRIBUTE4          VARCHAR2(240 BYTE),
  ATTRIBUTE5          VARCHAR2(240 BYTE),
  ATTRIBUTE6          VARCHAR2(240 BYTE),
  ATTRIBUTE7          VARCHAR2(240 BYTE),
  ATTRIBUTE8          VARCHAR2(240 BYTE),
  ATTRIBUTE9          VARCHAR2(240 BYTE),
  ATTRIBUTE10         VARCHAR2(240 BYTE),
  CREATED_BY          NUMBER                    NOT NULL,
  CREATION_DATE       DATE                      NOT NULL,
  LAST_UPDATED_BY     NUMBER                    NOT NULL,
  LAST_UPDATE_DATE    DATE                      NOT NULL,
  LAST_UPDATE_LOGIN   NUMBER
)



ALTER TABLE MOISS_DOC_LIBRARY_USER ADD 
CONSTRAINT MOISS_DOC_LIBRARY_USER_PK PRIMARY KEY (USER_DOC_ID) USING INDEX;



ALTER TABLE MOISS_DOC_LIBRARY_USER ADD 
CONSTRAINT MOISS_DOC_LIBRARY_USER_FK FOREIGN KEY (DOC_ID) 
REFERENCES MOISS_DOC_LIBRARY (DOC_ID);


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------



CREATE SEQUENCE MOISS_DOC_ID_S START WITH 1 NOCYCLE  NOCACHE ;			--FOR SEQUENCE NUMBER ON TABLE 1

CREATE SEQUENCE MOISS_USER_DOC_ID_S START WITH 1 NOCYCLE  NOCACHE ;		--SEQUENCE FOR SECOND TABLE


-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- 




GRANT ALL ON MOISS_DOC_LIBRARY TO APPS;
GRANT ALL ON MOISS_DOC_ID_S TO APPS;
GRANT ALL ON MOISS_DOC_LIBRARY_USER TO APPS;
GRANT ALL ON MOISS_USER_DOC_ID_S TO APPS;




--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------



 


