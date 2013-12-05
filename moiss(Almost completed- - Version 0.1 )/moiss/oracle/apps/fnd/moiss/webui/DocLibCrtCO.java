/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package moiss.oracle.apps.fnd.moiss.webui;



import com.sun.java.util.collections.HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;


import java.sql.SQLException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import java.util.Calendar;
import java.util.Locale;

import moiss.oracle.apps.moiss.doclib.schema.server.DocLibEOImpl;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.OAAttrValException;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.OARow;
import oracle.apps.fnd.framework.OAViewObject;
import oracle.apps.fnd.framework.server.OADBTransaction;
import oracle.apps.fnd.framework.server.OAEntityImpl;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OADataBoundValueViewObject;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.beans.layout.OAHeaderBean;

import oracle.apps.fnd.framework.webui.beans.message.OAMessageDateFieldBean;

import oracle.cabo.ui.data.DataObject;

import oracle.jbo.domain.BlobDomain;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import moiss.oracle.apps.CommonClass;




/**
 * Controller for ...
 */
public class DocLibCrtCO extends OAControllerImpl
{
  public static final String RCS_ID="$Header$";
  public static final boolean RCS_ID_RECORDED =
        VersionInfo.recordClassVersion(RCS_ID, "%packagename%");

  /**
   * Layout and page setup logic for a region.
   * @param pageContext the current OA page context
   * @param webBean the web bean corresponding to the region
   */
   OAApplicationModule am=null;
    String keyparam=null;
  public void processRequest(OAPageContext pageContext, OAWebBean webBean)
  {
    super.processRequest(pageContext, webBean);
      am=(OAApplicationModule)pageContext.getApplicationModule(webBean);
      OAViewObject vo=(OAViewObject)am.findViewObject("DocLibVO");
      OAViewObject pprvo=(OAViewObject)am.findViewObject("PPRVO");
      String keyparam=pageContext.getParameter("key");
      this.keyparam=keyparam;
      System.out.println("Value of Key PAram is "+keyparam);
      am.invokeMethod("handlePPRAction");
      OARow pprrow = (OARow)pprvo.getCurrentRow();
     
     
////////////
      

 ////---------------------------------------------------------------------------------------------------------------------------------------------------------------------
         
         /*Calendar Logic*/
         
// OAMessageDateFieldBean actionDateText = (OAMessageDateFieldBean) webBean.findChildRecursive("EffectiveEndDate1");
//
// actionDateText.setValue(pageContext,null);
// Calendar dateCal = Calendar.getInstance();
// java.util.Date dt = new java.util.Date();
// 
//      dateCal.add(Calendar.DAY_OF_MONTH, -2);
//      dateCal.add(Calendar.ZONE_OFFSET, 0);
// dt = dateCal.getTime();
// //System.out.println("No te----------n"+dt);
//
// //writeLog("AK",pageContext,"Start Date "+dt);
// ///actionDateText.setMinValue(dt);
// actionDateText.setMaxValue(dt);
// //dateCal.add(Calendar.DAY_OF_MONTH,31);
// //dt = dateCal.getTime();
// //  writeLog(XXPO_APP_SHORT_NAME,pageContext,"End date "+dt);
// //actionDateText.setMaxValue(dt);

////---------------------------------------------------------------------------------------------------------------------------------------------------------------------
      /*Update functionality for admin*/
      
      
     
          if(keyparam.equals("UPDATE"))
          {
              pprrow.setAttribute("UpdTableDispAttr", Boolean.FALSE);
              pprrow.setAttribute("EnaCrtReg", Boolean.TRUE);
              System.out.println(pprrow.getAttribute("UpdTableDispAttr")+""+pprrow.getAttribute("EnaCrtReg"));
              String docId = pageContext.getParameter("DocId");
              System.out.println("Doc Id value is sfjsdnfj"+docId);
              String l="Doc_id like '%"+docId+"%' ";
              System.out.println("Value of Document Id gets Printed"+l);
              vo.setWhereClause(l);
              System.out.println("Value Param Added");
              vo.executeQuery();  
              System.out.println(vo.first().getAttribute("DocumentName"));
          }
  
////---------------------------------------------------------------------------------------------------------------------------------------------------------------------    
 
 
 
 ////---------------------------------------------------------------------------------------------------------------------------------------------------------------------    


  /*Document create functionality for admin*/
  
   if(keyparam.equals("CREATE"))
   {
       pprrow.setAttribute("UpdTableDispAttr", Boolean.TRUE);
       pprrow.setAttribute("EnaCrtReg", Boolean.TRUE);
       System.out.println(pprrow.getAttribute("UpdTableDispAttr")+""+pprrow.getAttribute("EnaCrtReg"));
      Serializable[] sn={"DocLibVO"};
        am.invokeMethod("createRecord", sn);   

   }

////---------------------------------------------------------------------------------------------------------------------------------------------------------------------    
  
    
      

   
          if(keyparam.equals("VERUPD"))
             {
                 pprrow.setAttribute("UpdTableDispAttr", Boolean.TRUE);
                 pprrow.setAttribute("EnaCrtReg", Boolean.FALSE);
                 System.out.println(pprrow.getAttribute("UpdTableDispAttr")+""+pprrow.getAttribute("EnaCrtReg"));
                       am.invokeMethod("handlePPRAction");
                    
                      
                       pprrow.setAttribute("UpdTableDispAttr", Boolean.TRUE);
                      Serializable[] sn={"DocLibVO"};
                      
                      
                      
               
                // vo1.getCurrentRow().getAttribute("DocID");
              //   System.out.println(vo1.getCurrentRow().getAttribute("DocID")+"Record Fetched"+vo1.getCurrentRow().getAttribute("DocumentNumber"));
                 
                 
                      am.invokeMethod("createRecord", sn);
                OARow row=(OARow)vo.getCurrentRow();
                 OADBTransaction txn=(OADBTransaction)am.getOADBTransaction();
                 System.out.println("Values of VO and Txn"+vo+txn);
                 Number seqNoSno=txn.getSequenceValue("MOISS_DOC_ID_S");
                 row.setAttribute("DocId", seqNoSno);
                 row.setAttribute("DocumentName", pageContext.getParameter("attrparam2"));
                 row.setAttribute("DocumentNumber", pageContext.getParameter("attrparam3"));
                 row.setAttribute("CategoryDesc", pageContext.getParameter("attrparam4"));
                 row.setAttribute("OwningDeptDesc", pageContext.getParameter("attrparam5"));
                 row.setAttribute("Category", pageContext.getParameter("attrparam8"));
                 row.setAttribute("OwningDept", pageContext.getParameter("attrparam9"));
              //   row.setAttribute("EffectiveStartDate", pageContext.getParameter("attrparam6"));
              //   row.setAttribute("EffectiveEndDate", pageContext.getParameter("attrparam7"));
                 
               OAViewObject vo1=(OAViewObject)am.findViewObject("DocLibVO1");
               
               String docNo=pageContext.getParameter("attrparam3");
               System.out.println("Doc NO faosidfjijfoofs"+docNo);
               String l="DOCUMENT_NUMBER like '%"+docNo+"%' ";
               System.out.println("Value of Document Id gets Printed"+l);
               vo1.setWhereClause(l);
               vo1.setOrderByClause("VERSION_NUMBER desc");
               System.out.println("Value Param Added");
               vo1.executeQuery();  
                      
             }  
             else
                 {
                          pprrow.setAttribute("UpdTableDispAttr", Boolean.FALSE);
                     
                 }
      
 ////---------------------------------------------------------------------------------------------------------------------------------------------------------------------    
//                OAHeaderBean hb=(OAHeaderBean)webBean.findChildRecursive("region1");
//                hb.
    
    

  }

  /**
   * Procedure to handle form submissions for form elements in
   * a region.
   * @param pageContext the current OA page context
   * @param webBean the web bean corresponding to the region
   */
   int i=0;
  public void processFormRequest(OAPageContext pageContext, OAWebBean webBean)
  {
    super.processFormRequest(pageContext, webBean); 
   
   
          System.out.println("Welcome to PFR");
          OAViewObject votest=(OAViewObject)am.findViewObject("DocLibVO");
          System.out.println("Testing For VO"+votest);
    System.out.println("Event Gets invoked while uploading the Document"+pageContext.getParameter(EVENT_PARAM));
    System.out.println("Event Gets invoked while uploading the Document"+pageContext.getParameter(SOURCE_PARAM));
     
     
    System.out.println("Control came to create "+this.keyparam);
    
////---------------------------------------------------------------------------------------------------------------------------------------------------------------------    
    
    if(pageContext.getParameter(EVENT_PARAM).equals("Save")&&(this.keyparam.equals("VERUPD")))
    {
    
    //  Object a[]=pageContext.getParameter("attrparam");
  
         System.out.println("Control came to Version Update "+this.keyparam);        
        OAViewObject vo=(OAViewObject)am.findViewObject("DocLibVO");
        OADBTransaction txn=(OADBTransaction)am.getOADBTransaction();
        System.out.println("Values of VO and Txn"+vo+txn);
        System.out.println(vo.first().getAttribute("DocumentName"));
        System.out.println("Doc Id Vo"+vo.getCurrentRow().getAttribute("DocId")); 
        System.out.println("Lets Check"+vo.getCurrentRow().getAttribute("OwningDept")+vo.getCurrentRow().getAttribute("OwningDeptDesc")+vo.getCurrentRow().getAttribute("Category")+vo.getCurrentRow().getAttribute("CategoryDesc"));
        am.invokeMethod("apply");
         OAException confirmMessage = new OAException("Record Has Been Saved", OAException.CONFIRMATION);
        pageContext.putDialogMessage(confirmMessage);
        
      //  pageContext.forwardImmediatelyToCurrentPage(null,false,null);
    }
       if(pageContext.getParameter(EVENT_PARAM).equals("Save")&&(this.keyparam.equals("CREATE")))
       {
       System.out.println("Control came to create "+this.keyparam);
           //Go to Save Button and Disable server side validation to true As it checks the event before the occurenece
           OAViewObject vo=(OAViewObject)am.findViewObject("DocLibVO");
           OADBTransaction txn=(OADBTransaction)am.getOADBTransaction();
           
           if(pageContext.getParameter("DocumentNumber")!=null&&pageContext.getParameter("DocumentNumber")!=""&&pageContext.getParameter("EffectiveStartDate1")!=null&&pageContext.getParameter("EffectiveStartDate1")!=""&&pageContext.getParameter("DocumentName1")!=null&&pageContext.getParameter("DocumentName1")!="")
           {
           
               if(pageContext.getParameter("DocumentNumber").equals("0"))
               {
               
                   OAException confirmMessage = new OAException("Please Enter a Valid Document Number", OAException.CONFIRMATION);
                   pageContext.putDialogMessage(confirmMessage);
               }
               if(pageContext.getParameter("VersionNumber")!=null)
               {
               String vNo=pageContext.getParameter("VersionNumber");
               System.out.println("vNo"+vNo);
               CommonClass cc=new CommonClass();
               //cc.validatePattern(vNo, "^([[A-ZA-Z0-9\\.\\-])*$");
               
               //   if(cc.validatePattern(vNo, "^([[A-ZA-Z0-9\\.\\-])*$"))
                   if(cc.validatePattern(vNo, "^[A-Za-z0-9-_.]+$"))
               {
               
                 //  OAException confirmMessage = new OAException("Value matches for version Number", OAException.CONFIRMATION);
                //   pageContext.putDialogMessage(confirmMessage);
                
               
                 System.out.println("Value Matches ");
               }
               else
               {
               
                   OAException confirmMessage = new OAException("Please Enter a Valid Version  Number without sybol", OAException.CONFIRMATION);
                   pageContext.putDialogMessage(confirmMessage);
                   System.out.println("Value Does not Match ");
               
               }
               
               }
               
           System.out.println("Values of VO and Txn"+vo+txn);
           Number seqNoSno=txn.getSequenceValue("MOISS_DOC_ID_S");
            System.out.println("Sequence Number is "+seqNoSno);
             vo.getCurrentRow().setAttribute("DocId", seqNoSno);
           System.out.println("Doc Id Vo"+vo.getCurrentRow().getAttribute("DocId")); 
           if(i==1)
           {
               vo.getCurrentRow().setAttribute("MustRead", "Y");
               System.out.println(vo.getCurrentRow().getAttribute("MustRead"));
           }
           System.out.println("Lets Check"+vo.getCurrentRow().getAttribute("OwningDept")+vo.getCurrentRow().getAttribute("OwningDeptDesc")+vo.getCurrentRow().getAttribute("Category")+vo.getCurrentRow().getAttribute("CategoryDesc"));
           am.invokeMethod("apply");
            OAException confirmMessage = new OAException("Record Has Been Saved", OAException.CONFIRMATION);
           pageContext.putDialogMessage(confirmMessage);
           }
           else
           {
               OAException confirmMessage = new OAException("Please fill out the required Fields", OAException.CONFIRMATION);
               pageContext.putDialogMessage(confirmMessage);
           }
         //  pageContext.forwardImmediatelyToCurrentPage(null,false,null);
       }
    
    
          if(pageContext.getParameter(EVENT_PARAM).equals("Save")&&(this.keyparam.equals("UPDATE")))
          {
          System.out.println("Control came to create "+this.keyparam);
              //Go to Save Button and Disable server side validation to true As it checks the event before the occurenece
            
              am.invokeMethod("apply");
               OAException confirmMessage = new OAException("Record Has Been Saved", OAException.CONFIRMATION);
              pageContext.putDialogMessage(confirmMessage);
              
            //  pageContext.forwardImmediatelyToCurrentPage(null,false,null);
          }
    
    
             if(pageContext.getParameter(EVENT_PARAM).equals("docNoVal")&&(this.keyparam.equals("CREATE")))
             {
                 System.out.println("Inside the Doc no Val Document no Validation "+EVENT_PARAM+this.keyparam);
                 if(pageContext.getParameter("DocumentNumber").equals("0"))
                 {
                 
                     OAException confirmMessage = new OAException("Please Enter a Valid Document Number", OAException.CONFIRMATION);
                     pageContext.putDialogMessage(confirmMessage);
                 }
             }
    if(pageContext.getParameter(EVENT_PARAM).equals("verNoVal")&&(this.keyparam.equals("CREATE")))
    {
        System.out.println("Inside the Doc no  Version Number Validation "+EVENT_PARAM+this.keyparam);
        
        String vNo=pageContext.getParameter("VersionNumber");
        System.out.println("vNo"+vNo);
        CommonClass cc=new CommonClass();
        //cc.validatePattern(vNo, "^([[A-ZA-Z0-9\\.\\-])*$");
        
     //   if(cc.validatePattern(vNo, "^([[A-ZA-Z0-9\\.\\-])*$"))
            if(cc.validatePattern(vNo, "^[A-Za-z0-9-_.]+$"))
        {
        
          //  OAException confirmMessage = new OAException("Value matches for version Number", OAException.CONFIRMATION);
         //   pageContext.putDialogMessage(confirmMessage);
         
      
          System.out.println("Value Matches ");
        }
        else
        {
        
            OAException confirmMessage = new OAException("Please Enter a Valid Version  Number without sybol", OAException.CONFIRMATION);
            pageContext.putDialogMessage(confirmMessage);
            System.out.println("Value Does not Match ");
        
        }
    }
             
    
    
    
      if (pageContext.getParameter(EVENT_PARAM).equals("ClearButton"))
      {     
          HashMap hm=new HashMap();  //Tried to send parameter through SetFowardURL
           hm.put("keyparam", this.keyparam);
          
          pageContext.forwardImmediatelyToCurrentPage(hm, false, "Y");
          
//          //Parameters has been set in Image Item.. Look up for Reference
//            pageContext.setForwardURL("OA.jsp?page=/moiss/oracle/apps/fnd/moiss/webui/DocLibCrtPG",
//            null,
//            //OAWebBeanConstants.KEEP_NO_DISPLAY_MENU_CONTEXT,
//             OAWebBeanConstants.KEEP_NO_DISPLAY_MENU_CONTEXT,
//            null,
//            hm, //HashMap
//            
//            false,
//            OAWebBeanConstants.ADD_BREAD_CRUMB_YES,
//            OAWebBeanConstants.IGNORE_MESSAGES);       
        
        
      }
          if(pageContext.getParameter(EVENT_PARAM).equals("linktoviewpg"))
         {
         
              HashMap hm = new HashMap(1);
              hm.put("param", "ADMIN");           
          
             // pageContext.
              pageContext.setForwardURL("OA.jsp?page=/moiss/oracle/apps/fnd/moiss/webui/DocLibPG",
              null,
              //OAWebBeanConstants.KEEP_NO_DISPLAY_MENU_CONTEXT,
               OAWebBeanConstants.KEEP_NO_DISPLAY_MENU_CONTEXT,
              null,
              hm, 
              true,
              OAWebBeanConstants.ADD_BREAD_CRUMB_YES,
              OAWebBeanConstants.IGNORE_MESSAGES);
              
 
          }


////---------------------------------------------------------------------------------------------------------------------------------------------------------------------    
  
        /* Effective Start Date using here */
        
        
    if(pageContext.getParameter(EVENT_PARAM).equals("esdate"))
    {
        System.out.println("The date has Been Typed"+pageContext.getParameter("EffectiveStartDate"));
        Date ddate = (Date)am.findViewObject("DocLibVO").first().getAttribute("EffectiveStartDate");
        OADBTransaction txn=(OADBTransaction) am.getOADBTransaction();
        Date currDate=(Date)txn.getCurrentDBDate();
       
        long dobDate = ddate.dateValue().getTime();
        
       
    }
    
    
    
    if("mustread".equals(pageContext.getParameter(EVENT_PARAM)))
    {
        OAViewObject vo=(OAViewObject)am.findViewObject("DocLibVO");
        i=1;
        this.i=i;
       
        
    }
////---------------------------------------------------------------------------------------------------------------------------------------------------------------------    
       
       /* Effective End Date using here */
       
       
    if(pageContext.getParameter(EVENT_PARAM).equals("eedate"))
    {
         java.util.Date  eedate=null;
        java.util.Date cdate=null;
        System.out.println("The date has Been Typed"+pageContext.getParameter("EffectiveEndDate1"));
        try{
                    String start_dt = (pageContext.getParameter("EffectiveEndDate1")).toString();           //Obtaining the Date from the user Input for verification
                    DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy"); //Formatting  --> Have to dig inside it   yyyy-MM-dd
                    eedate = (java.util.Date)formatter.parse(start_dt);           //Conversion of String to Date
                    System.out.println("Output for Date lets check"+eedate); 
                   
             /*Getting Current Date from DB*/      
                    OADBTransaction txn=(OADBTransaction) am.getOADBTransaction();
                    oracle.jbo.domain.Date currDate=txn.getCurrentDBDate();       //Obtaining Current date
                    
                    String currdate1=currDate.toString();   //Convering to String to make to java.util.Date
                    System.out.println("Current Date is "+currdate1);
                    currdate1=currdate1.substring(0, 10);
                    System.out.println(currdate1);
                    DateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
                    cdate = (java.util.Date)formatter1.parse(currdate1);   //Gets converted
                    System.out.println("Output for Date lets check"+cdate);    //Testing Output
           } 
        
 
        catch(ParseException e)
        {
            System.out.println("Exception Occured during Date "+e);
          
        }
        if(cdate.compareTo(eedate)==1)
        {
             System.out.println("Date is invalid");
            OARow row=(OARow)votest.getCurrentRow();
            OAViewObject vo=(OAViewObject)am.findViewObject("DocLibVO");
           DocLibEOImpl eo=null;
           // OAEntityImpl eo=null;
            throw new OAAttrValException (
                                       OAException.TYP_VIEW_OBJECT, // indicates VO row source
                                       "DocLibVO", //View Object full usage name
                                       row.getKey(), // row primary key
                                       "EffectiveEndDate", //attribute name
                                       (pageContext.getParameter("EffectiveEndDate1")).toString(), // bad attribute value 
                                       "AK", //message application short name
                                       "ATTR_EXCEPTION"); // message name
//            eo.setAttributeInternal("EffectiveEndDate", (pageContext.getParameter("EffectiveEndDate1")).toString());
           
        }
        else 
        {
           
              
            System.out.println("Date is valid"); 
           
        }
      
    }
       


////----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     





////----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
       System.out.println(EVENT_PARAM);
    OAApplicationModule am = (OAApplicationModule) pageContext.getApplicationModule(webBean);
    // String fileName = null;
    // DataObject fileUploadData =(DataObject)pageContext.getNamedDataObject("ssofileupload");
    // fileName = (String)fileUploadData.selectValue(null, "sso.csv");
    //
    // System.out.println("Filename"+fileName);
    if("PARAM_TO_BE_ENTERED".equals(pageContext.getParameter(EVENT_PARAM)))
    {

    System.out.println("Inside display");

    DataObject fileUploadData =(DataObject)pageContext.getNamedDataObject("DocumentFile1");
    System.out.println("File upload Data   "+fileUploadData);
    String ufileName = null;
    String contentType = null;
    Long fileSize = null;
    Integer fileType = new Integer(6);
    BlobDomain uploadedByteStream = null;
    BufferedReader in = null;

    try
    {
    System.out.println("Inside try");
    
    ufileName = (String)fileUploadData.selectValue(null, "UPLOAD_FILE_NAME");
        contentType =(String)fileUploadData.selectValue(null, "UPLOAD_FILE_MIME_TYPE");
 
     
    System.out.println("Filename"+ufileName+"Content Type"+contentType
    
    );
     
    uploadedByteStream = (BlobDomain)fileUploadData.selectValue(null, (fileUploadData.selectValue(null, "UPLOAD_FILE_NAME")).toString());
    System.out.println("After uploadedByteStream "+uploadedByteStream);
//    in = new BufferedReader(new InputStreamReader(uploadedByteStream.getBinaryStream()));
//    System.out.println("After BufferedReader "+in);


    fileSize = new Long(uploadedByteStream.getLength());
        fileSize = new Long(uploadedByteStream.getLength());

    System.out.println("fileSize"+fileSize);
    }
    catch(NullPointerException ex)
    {
    throw new OAException("Please Select a File to Upload", OAException.ERROR);
    }
////----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//        try
//         {
//          DataObject fileUploadData =  pageContext.getNamedDataObject("MessageFileUpload");
//
//        //FileUploading is my MessageFileUpload Bean Id
//          if(fileUploadData!=null)
//          {
//           String uFileName = (String)fileUploadData.selectValue(null, "UPLOAD_FILE_NAME"); 
//           String contentType = (String) fileUploadData.selectValue(null, "UPLOAD_FILE_MIME_TYPE");  
//           System.out.println("User File Name---->"+uFileName);
//
//           FileOutputStream output = null;
//           InputStream input = null;
//
//           BlobDomain uploadedByteStream = (BlobDomain)fileUploadData.selectValue(null, uFileName);
//           System.out.println("uploadedByteStream---->"+uploadedByteStream);
//                                  
//           File file = new File("D:\\PRajkumar", uFileName);  
//           System.out.println("File output---->"+file);
//
//           output = new FileOutputStream(file);
//
//           System.out.println("output----->"+output);
//           input = uploadedByteStream.getInputStream();
//
//           System.out.println("input---->"+input);
//           byte abyte0[] = new byte[0x19000];
//           int i;
//            
//           while((i = input.read(abyte0)) > 0)
//           output.write(abyte0, 0, i);
//
//           output.close();
//           input.close();
//          }
//         }
//         catch(Exception ex)
//         {
//          throw new OAException(ex.getMessage(), OAException.ERROR);
//         }     


//
//    try
//    {
//    String lineReader="";
//    long t =0;
//    String[] linetext;
//    while (((lineReader = in.readLine()) !=null) )
//    {
//    if (lineReader.trim().length()>0)
//    {
//    System.out.println("lineReader"+lineReader.length());
//    linetext = lineReader.split(",");
//    t++;
//    System.out.println(t + " - " +
//    linetext[0].trim() + " - " + linetext[1].trim() + " - " +
//    linetext[2].trim() + " - " + linetext[3].trim() + " - " +
//    linetext[4].trim() + " - " + linetext[5].trim() );
//
//    }
//    }
//    }
//
//    catch (IOException e)
//    {
//    throw new OAException(e.getMessage(),OAException.ERROR);
//    }


    }
////---------------------------------------------------------------------------------------------------------------------------------------------------------------------    

/*Inserting Blob or File programatically*/

//      private BlobDomain createBlobDomain(OAPageContext pageContext,      OAWebBean webBean)
//      {
//      // init the internal variables
//      InputStream in = null;
//      BlobDomain blobDomain = null;
//      OutputStream out = null;
//      try {
//      DataObject fileUploadData =      (DataObject)pageContext.getNamedDataObject("DocumentFile1");
//      String pFileName =
//      (String)fileUploadData.selectValue(null, "UPLOAD_FILE_NAME");
//      // BlobDomain uploadedByteStream = (BlobDomain)fileUploadData.selectValue(null,pFileName);
//      BlobDomain uploadedByteStream = (BlobDomain)pageContext.getParameterObject(pFileName);
//
//      if(uploadedByteStream!=null ) { /////////////////
//
//      // Get the input stream representing the data from the client
//      in = uploadedByteStream.getInputStream();
//      // create the BlobDomain datatype to store the data in the db
//      blobDomain = new BlobDomain();
//      // get the outputStream for hte BlobDomain
//      
//      out = blobDomain.getBinaryOutputStream();
//      byte buffer[] = new byte[8192];
//      for (int bytesRead = 0; (bytesRead = in.read(buffer, 0, 8192)) != -1; )
//      out.write(buffer, 0, bytesRead);
//      in.close();
//
//      } /////////////
//      } catch (IOException e) {
//      e.printStackTrace();
//      } catch (SQLException e) {
//      e.fillInStackTrace();
//      }
//      return blobDomain;
//
//      }
//    
//  }


 ////---------------------------------------------------------------------------------------------------------------------------------------------------------------------    

}
}