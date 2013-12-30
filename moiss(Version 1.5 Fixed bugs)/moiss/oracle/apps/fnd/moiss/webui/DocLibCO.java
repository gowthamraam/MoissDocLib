/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package moiss.oracle.apps.fnd.moiss.webui;


import com.sun.java.util.collections.HashMap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Enumeration;
 
import java.util.List;

import moiss.oracle.apps.moiss.doclib.server.DocIdUVORowImpl;

import oracle.apps.fnd.common.MessageToken;
import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAApplicationModule;

import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.OAViewObject;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OARenderingContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.beans.layout.OADefaultSingleColumnBean;
import oracle.apps.fnd.framework.webui.beans.layout.OATableLayoutBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageCheckBoxBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageTextInputBean;
import oracle.apps.fnd.framework.webui.beans.table.OATableBean;
import oracle.apps.jtf.admin.adminconsole.RenderingContext;
import oracle.jbo.domain.Number;
import oracle.apps.fnd.framework.server.OAViewRowImpl;
import oracle.apps.fnd.framework.OARow;

import oracle.apps.fnd.framework.server.OADBTransaction;
import oracle.apps.fnd.framework.webui.OADialogPage;
import oracle.apps.fnd.framework.webui.beans.table.OAAdvancedTableBean;

import oracle.cabo.ui.data.DataObjectList;

import oracle.cabo.ui.data.DictionaryData;

import oracle.jbo.Row;

import oracle.jbo.domain.BlobDomain;

import org.omg.CORBA.Current;

//import xxhlp.oracle.apps.xxhlp.recruit.server.ImgViewObjImpl;

/**
 * 
 * Controller for ...
 */
public class DocLibCO extends OAControllerImpl
{
  public static final String RCS_ID="$Header$";
  public static final boolean RCS_ID_RECORDED =
        VersionInfo.recordClassVersion(RCS_ID, "%packagename%");

  /**
   * Layout and page setup logic for a region.
   * @param pageContext the current OA page context
   * @param webBean the web bean corresponding to the region
   */
   String role;
  public void processRequest(OAPageContext pageContext, OAWebBean webBean)
  {
    super.processRequest(pageContext, webBean);
      OAApplicationModule am=(OAApplicationModule)pageContext.getApplicationModule(webBean); 
      OAViewObject vo=(OAViewObject)am.findViewObject("DocLibVO");
              String role=pageContext.getParameter("param");
//role="ADMIN";
      this.role=role;
      System.out.println("Val in role is sfjsflhsljf"+role);
      
            
            
            String k=(pageContext.getUserId())+"";
            System.out.println("pageContext.getUserId()"+k);
            OAViewObject vou=(OAViewObject)am.findViewObject("DocIdUVO");
            System.out.println("Obating fhajkfnajksdfjahbdf"+vou);
       //    vou.setWhereClauseParam(0, k);
     
             
            
 //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
      
      
      /*Displaying  the Results*/
      
      System.out.println("To check VO is not null"+vou);
          if(vou!=null)
          {   
                       vou.executeQuery();
          }
        
     
           
           
 //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 /*  PPR for handling Admin Functionalites   */
 
 
 
  OAViewObject pprvo=(OAViewObject)am.findViewObject("PPRVO");
       am.invokeMethod("handlePPRAction");
       
            OARow row = (OARow)pprvo.getCurrentRow();
     //  String role="ADMIN";
          //  String role=pageContext.getParameter("param");
        if(role.equals("ADMIN"))
           {
                    row.setAttribute("DispAdminAttr", Boolean.TRUE);
           }
           else
               {
                        row.setAttribute("DispAdminAttr", Boolean.FALSE);
               }
        
            String userName = pageContext.getUserName();
         
        System.out.println( "User Name is of this user is "+row.getAttribute("EnaCrtReg"));
            System.out.println( "User Name is of this user is "+row.getAttribute("DispAdminAttr"));
   
        System.out.println( "User Name is of this user is "+userName);
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
       
        
        
//             OATableBean table = (OATableBean)webBean.findChildRecursive("xxMoissDocLibVO1"); // We need to format the Switcher
//             
//             // (this isn't done automatically for Switchers as it is for
//             // plain image columns). We start by getting the table's
//             // column formats.
//             // NOTE!!! You must call the prepareForRendering() method on the table
//              
//             // formatting columns. Furthermore, this call must be sequenced *after* the
//             // table is queried, and *after* you do any control bar manipulation.
//             table.prepareForRendering(pageContext);
//             DataObjectList columnFormats = table.getColumnFormats();
//             DictionaryData columnFormat = null;
//           //  int childIndex = pageContext.findChildRecursive(table, "DeleteSwitcher");
//             try
//             {
//             int childIndex=pageContext.findChildIndex(table, "DeleteSwitcher");
//                 columnFormat =(DictionaryData)columnFormats.getItem(childIndex);
//                 columnFormat.put(COLUMN_DATA_FORMAT_KEY, ICON_BUTTON_FORMAT);
//             }
//             catch(Exception e)
//             {
//                System.out.println(e);
//             }
//            
        
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
       /*Functionality handled by DeleteSwitcher*/        
        
        
        
        }
       /****To Hide the Check box (Dint Work yet) To Make **
       OAAdvancedTableBean ad=(OAAdvancedTableBean)webBean.findChildRecursive("region111123");
      // System.out.println("Get AttriBute Val"+ad.get);
      OAMessageCheckBoxBean cb=(OAMessageCheckBoxBean)webBean.findChildRecursive("item91229");
      System.out.println("Value in check Box"+cb.getValue());

    //   if(ad.getAttributeValue("item91229"))
    
        */
       


  /**
   * Procedure to handle form submissions for form elements in
   * a region.
   * @param pageContext the current OA page context
   * @param webBean the web bean corresponding to the region
   */
  public void processFormRequest(OAPageContext pageContext, OAWebBean webBean)
  {
    super.processFormRequest(pageContext, webBean);
      OAApplicationModule am=(OAApplicationModule)pageContext.getApplicationModule(webBean);
      OAViewObject vo=(OAViewObject)am.findViewObject("DocIdUVO");
     
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------   
      /* Code to Route to Admin Page*/
    
       
          if (pageContext.getParameter(EVENT_PARAM).equals("NewDoc"))
          {     
              HashMap hm=new HashMap();
              hm.put("key", "CREATE");
              pageContext.setForwardURL("OA.jsp?page=/moiss/oracle/apps/fnd/moiss/webui/DocLibCrtPG",
              null,
              //OAWebBeanConstants.KEEP_NO_DISPLAY_MENU_CONTEXT,
               OAWebBeanConstants.KEEP_NO_DISPLAY_MENU_CONTEXT,
              null,
              hm, 
              false,
              OAWebBeanConstants.ADD_BREAD_CRUMB_YES,
              OAWebBeanConstants.IGNORE_MESSAGES);
          }
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------       
     


//---------------------------------------------------------------------------------------------------------------------------------------------------------------------   

            /* Code to Route to Admin role Update Page*/
 
           if (pageContext.getParameter(EVENT_PARAM).equals("update") )
           {     
                           System.out.println("Event named update "+EVENT_PARAM+SOURCE_PARAM);
                         String rowReference = pageContext.getParameter(OAWebBeanConstants.EVENT_SOURCE_ROW_REFERENCE);    //Obtaining the Row Reference of the current Row
                         Serializable[] s={rowReference};//    Sending the parameter thro a Serializable parameter
                         OARow row = (OARow)am.findRowByRef(rowReference); //Getting the rowRefence and getting as a row
                         System.out.println("Value of The Rwo"+row);   //Checking Value of the Row
                         
                         if (row!=null)
                        {
                             System.out.println("Something Happens over here"+row.getAttribute("DocId")); //checking the Doc Id for Verification whether correct row gets fetched
                            HashMap hm=new HashMap();  //Tried to send parameter through SetFowardURL
                             hm.put("doc", row.getAttribute("DocId"));
                          
                         
                         
                           //Parameters has been set in Image Item.. Look up for Reference
                              pageContext.setForwardURL("OA.jsp?page=/moiss/oracle/apps/fnd/moiss/webui/DocLibCrtPG",
                              null,
                              //OAWebBeanConstants.KEEP_NO_DISPLAY_MENU_CONTEXT,
                               OAWebBeanConstants.KEEP_NO_DISPLAY_MENU_CONTEXT,
                              null,
                              null, //HashMap
                              
                              true,
                              OAWebBeanConstants.ADD_BREAD_CRUMB_YES,
                              OAWebBeanConstants.IGNORE_MESSAGES);                       
                        }
           }


//   
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------      
/******************************************/
/* Search when Find Button Clikced  */
      if (pageContext.getParameter(EVENT_PARAM).equals("Search"))
      {
           
           
          Enumeration x=null;
           x=pageContext.getParameterNames();
                    if(x!=null){
          
                    System.out.println("Elements in Enum"+x);
                    while(x.hasMoreElements())
                    {
                    String aParamName = (String)x.nextElement();
                    System.out.println("Obatining the Child Names     : "+aParamName);
                    }
                      System.out.println("VO Gets Queried");
          
                }
           
           
          System.out.println("pageContext.getParameter(\"DocumentName\")"+pageContext.getParameter("DocumentName"));
          System.out.println("pageContext.getParameter(\"Category\")"+pageContext.getParameter("Category"));
          System.out.println("pageContext.getParameter(\"OwningDept\")"+pageContext.getParameter("Dept"));
          System.out.println("pageContext.getParameter(\"DocumentNumber\")"+pageContext.getParameter("DocumentNumber"));
          System.out.println("pageContext.getParameter(\"EffectiveStartDate\")"+pageContext.getParameter("EffectiveStartDate"));
          System.out.println("pageContext.getParameter(\"EffectiveEndDate\")"+pageContext.getParameter("EffectiveEndDate"));
          
          List whClauseParams = new ArrayList();
          if (pageContext.getParameter("DocumentNumber") != null && pageContext.getParameter("DocumentNumber") != "") { 
              try
                {
               // vo.setWhereClauseParam(0, pageContext.getParameter("DocumentName"));
                   whClauseParams.add(" and QRSLT.DOCUMENT_NUMBER like '%"+pageContext.getParameter("DocumentNumber")+ "%'");
                }
                catch(Exception e){
                System.out.println(e);
                }
          }
          
          
          if (pageContext.getParameter("DocumentName") != null && pageContext.getParameter("DocumentName")!="") { 
              try
                {
               // vo.setWhereClauseParam(0, pageContext.getParameter("DocumentName"));
                   whClauseParams.add(" and QRSLT.DOCUMENT_NAME like '%"+pageContext.getParameter("DocumentName")+ "%'");
                }
                catch(Exception e){
                System.out.println(e);
                }
          }
          if (pageContext.getParameter("Category")!= null && pageContext.getParameter("Category")!="") { 
              try
                {
               // vo.setWhereClauseParam(0, pageContext.getParameter("DocumentName"));
                   whClauseParams.add(" and QRSLT.CATEGORY_DESC like '%"+pageContext.getParameter("Category")+ "%'");
                }
                catch(Exception e){
                System.out.println(e);
                }
          }
          if (pageContext.getParameter("Dept") != null &&pageContext.getParameter("Dept")!="") { 
              try
                {
               // vo.setWhereClauseParam(0, pageContext.getParameter("DocumentName"));
                   whClauseParams.add(" and QRSLT.OWNING_DEPT_DESC like '%"+pageContext.getParameter("Dept")+ "%'");
                }
                catch(Exception e){
                System.out.println(e);
                }
          }
          
          

          if (pageContext.getParameter("EffectiveStartDate") != null && pageContext.getParameter("EffectiveStartDate")!="") { 
              try
                {
               // vo.setWhereClauseParam(0, pageContext.getParameter("EffectiveStartDate"));
                   whClauseParams.add(" and QRSLT.EFFECTIVE_START_DATE like '%"+pageContext.getParameter("EffectiveStartDate")+ "%' ");
                }
                catch(Exception e){
                System.out.println(e);
                }
          }
          if (pageContext.getParameter("EffectiveEndDate") != null && pageContext.getParameter("EffectiveEndDate")!="" ) { 
              try
                {
               // vo.setWhereClauseParam(0, pageContext.getParameter("EffectiveStartDate"));
                   whClauseParams.add(" and QRSLT.EFFECTIVE_END_DATE like '%"+pageContext.getParameter("EffectiveStartDate")+ "%' ");
                }
                catch(Exception e){
                System.out.println(e);
                }
          }
          
          
            System.out.println("To check VO is not null"+vo);
           if(vo!=null)
           {
         
                String sqlparam=" ";
                if(whClauseParams.isEmpty())
               {
                            System.out.println("No Params for Search");
                }
                else
                {
                              for (int i = 0; i < whClauseParams.size(); i++) 
                              {
                                    String k=whClauseParams.get(i)+"";
                                    System.out.println(whClauseParams.get(i));
                                    sqlparam=sqlparam.concat(k);
                                    System.out.println("The param is "+sqlparam);                                    
                              }
           
                                if((sqlparam!=null)&&(sqlparam!=""))
                                {
                                    sqlparam=sqlparam.substring(5);
                                    System.out.println("Modified param"+sqlparam);
                                    vo.setWhereClause(sqlparam);                            
                                    vo.executeQuery();
                                }
                     
                  }
            }
      }
//        
////---------------------------------------------------------------------------------------------------------------------------------------------------------------------
//
// /* Check box implementation Logic */
//      if (pageContext.getParameter(EVENT_PARAM).equals("Just"))
//      {
//          String rowReference = pageContext.getParameter(OAWebBeanConstants.EVENT_SOURCE_ROW_REFERENCE);    //Obtaining the Row Reference of the current Row
//          Serializable[] s={rowReference};//    Sending the parameter thro a Serializable parameter
//          OARow row = (OARow)am.findRowByRef(rowReference); //Getting the rowRefence and getting as a row
//          System.out.println("Value of The Rwo"+row);   //Checking Value of the Row
//          if (row!=null)
//         {
//              System.out.println("Something Happens over here"+row.getAttribute("DocId")); //checking the Doc Id for Verification whether correct row gets fetched
//              System.out.println("Something Happens over here"+row.getAttribute("ReadAcceptFlag"));  //checking the Check Box value
//               System.out.println("Something Happens over here for DocumentFile"+row.getAttribute("DocumentFile"));  //checking the Check Box value
//              
//              if((row.getAttribute("ReadAcceptFlag")=="Y"))
//                {
//                    
//                    OAMessageCheckBoxBean cb=(OAMessageCheckBoxBean)webBean.findChildRecursive("item91229");
//                    cb.setRendered(false);
//                
//                }
//        
//      
//    
//   
//    }
//    


////---------------------------------------------------------------------------------------------------------------------------------------------------------------------

/*Logic for commiting the values When the check box is checked */

// if (pageContext.getParameter(EVENT_PARAM).equals("Read"))
//       {
////             Serializable[] sn1={"DocLibUserVO"};
////             am.invokeMethod("createRecord", sn1);
//           String rowReference = pageContext.getParameter(OAWebBeanConstants.EVENT_SOURCE_ROW_REFERENCE);    //Obtaining the Row Reference of the current Row
//           Serializable[] s={rowReference};//    Sending the parameter thro a Serializable parameter
//          //  OARow row1=am.invokeMethod("obtainRow", s);
//           OARow row = (OARow)am.findRowByRef(rowReference);
//           System.out.println("Getting the rown fasdkf"+row);
//                       System.out.println("Getting doc Id"+row.getAttribute("DocId"));
//             row.setAttribute("UserId", pageContext.getUserId());
//           OARow urow = (OARow)am.findViewObject("DocLibUserVO").getCurrentRow();
//           
//           
//           OADBTransaction txn=(OADBTransaction)am.getOADBTransaction();
//           Number seqNoSno1=txn.getSequenceValue("MOISS_USER_DOC_ID_S");
//           urow.setAttribute("UserDocId", seqNoSno1);
//           urow.getAttribute("UserDocId");
//           
//           
//           urow.setAttribute("UserId", pageContext.getUserId());
//           urow.getAttribute("UserId");
//           
//           urow.setAttribute("DocId", row.getAttribute("DocId"));
//           urow.getAttribute("DocId");
//           
////           urow.setAttribute("ReadAcceptFlag", "Y" );
////           urow.getAttribute("ReadAcceptFlag");
//           
//           
//        OAMessageCheckBoxBean cb=(OAMessageCheckBoxBean)webBean.findChildRecursive("item91229");
//        System.out.println("Value of Check Box"+cb.getValue());
//    //    am.invokeMethod("apply");
//       }
//       




     if (pageContext.getParameter(EVENT_PARAM).equals("VerUpd"))
           {
                  
               System.out.println("Inside the Version Update Event");  
               String rowReference = pageContext.getParameter(OAWebBeanConstants.EVENT_SOURCE_ROW_REFERENCE);    //Obtaining the Row Reference of the current Row
               System.out.println("Row Ref"+rowReference);         
               OARow row = (OARow)am.findRowByRef(rowReference);
               System.out.println("Getting the rown fasdkf"+row);
               System.out.println("Getting doc Id"+row.getAttribute("DocId"));
               System.out.println("Getting doc Id"+row.getAttribute("DocumentName"));
               System.out.println("Getting doc Id"+row.getAttribute("DocumentNumber"));
               System.out.println("Getting doc Id"+row.getAttribute("CategoryDesc"));
               System.out.println("Getting doc Id"+row.getAttribute("OwningDeptDesc"));
               System.out.println("Getting doc Id"+row.getAttribute("Category"));
               System.out.println("Getting doc Id"+row.getAttribute("OwningDept"));
               System.out.println("Getting doc Id"+row.getAttribute("EffectiveStartDate"));
               System.out.println("Getting doc Id"+row.getAttribute("EffectiveStartDate"));
               Object a[]={row.getAttribute("DocId"), row.getAttribute("DocumentName"), row.getAttribute("DocumentNumber"), row.getAttribute("CategoryDesc"), row.getAttribute("OwningDeptDesc")};
               HashMap hm=new HashMap();
               System.out.println("Val of a is "+a[0] + a);
             //  hm.put("attrparam", {row.getAttribute("DocId"), row.getAttribute("DocumentName"), row.getAttribute("DocumentNumber"),  row.getAttribute("OwningDeptDesc"),  row.getAttribute("CategoryDesc")});
                hm.put("attrparam1", row.getAttribute("DocId"));
               hm.put("attrparam2", row.getAttribute("DocumentName"));
               hm.put("attrparam3", row.getAttribute("DocumentNumber"));
               hm.put("attrparam4",row.getAttribute("CategoryDesc"));
               hm.put("attrparam5",row.getAttribute("OwningDeptDesc"));
               hm.put("attrparam6",row.getAttribute("EffectiveStartDate"));
               hm.put("attrparam7",row.getAttribute("EffectiveEndDate"));
               hm.put("attrparam8",row.getAttribute("Category"));
               hm.put("attrparam9",row.getAttribute("OwningDept"));
             
               hm.put("DocId", row.getAttribute("DocId"));
               hm.put("key", "VERUPD");
               pageContext.setForwardURL("OA.jsp?page=/moiss/oracle/apps/fnd/moiss/webui/DocLibCrtPG",
               null,
               //OAWebBeanConstants.KEEP_NO_DISPLAY_MENU_CONTEXT,
                OAWebBeanConstants.KEEP_NO_DISPLAY_MENU_CONTEXT,
               null,
               hm, //HashMap
               
               true,
               OAWebBeanConstants.ADD_BREAD_CRUMB_YES,
               OAWebBeanConstants.IGNORE_MESSAGES);         
               System.out.println("Hash map Value"+hm);
               /*
                          //  row.setAttribute("UserId", pageContext.getUserId());
                          OARow urow = (OARow)am.findViewObject("DocLibUserVO").getCurrentRow();
                          System.out.println("Obtaining the val of UROW"+urow);
               
               
                          OADBTransaction txn=(OADBTransaction)am.getOADBTransaction();
                          Number seqNoSno1=txn.getSequenceValue("MOISS_USER_DOC_ID_S");
                          System.out.println("Values of VO and Nu"+txn+seqNoSno1);
                          urow.setAttribute("UserDocId", seqNoSno1);
                          urow.getAttribute("UserDocId");
               
               
                          urow.setAttribute("UserId", pageContext.getUserId());
                          urow.getAttribute("UserId");
               
                          urow.setAttribute("DocId", row.getAttribute("DocId"));
                          urow.getAttribute("DocId");
               
                         urow.setAttribute("ReadAcceptFlag", "Y" );
                        urow.getAttribute("ReadAcceptFlag");
               
               
                       OAMessageCheckBoxBean cb=(OAMessageCheckBoxBean)webBean.findChildRecursive("item91229");
                       System.out.println("Value of Check Box"+cb.getValue());
                       am.invokeMethod("apply");
               
                */
            
           }
           
           

                      if (pageContext.getParameter(EVENT_PARAM).equals("Boad"))
                            {
                                   Serializable[] sn1={"DocLibUserVO"};
                                   am.invokeMethod("createRecord", sn1);
                      
                      System.out.println("Inside the Read Event");
                     // am.invokeMethod("apply");
                                String rowReference = pageContext.getParameter(OAWebBeanConstants.EVENT_SOURCE_ROW_REFERENCE);    //Obtaining the Row Reference of the current Row
                                System.out.println("Rwo Ref"+rowReference);
                                Serializable[] s={rowReference};//    Sending the parameter thro a Serializable parameter
                                OARow row = (OARow)am.findRowByRef(rowReference);
                                System.out.println("Getting the rown fasdkf"+row);
                                System.out.println("Getting doc Id"+row.getAttribute("DocId"));
                                           //  row.setAttribute("UserId", pageContext.getUserId());
                                           OARow urow = (OARow)am.findViewObject("DocLibUserVO").getCurrentRow();
                                           System.out.println("Obtaining the val of UROW"+urow);
                                
                                
                                           OADBTransaction txn=(OADBTransaction)am.getOADBTransaction();
                                           Number seqNoSno1=txn.getSequenceValue("MOISS_USER_DOC_ID_S");
                                           System.out.println("Values of VO and Nu"+txn+seqNoSno1);
                                           urow.setAttribute("UserDocId", seqNoSno1);
                                           urow.getAttribute("UserDocId");
                                
                                
                                           urow.setAttribute("UserId", pageContext.getUserId());
                                           urow.getAttribute("UserId");
                                
                                           urow.setAttribute("DocId", row.getAttribute("DocId"));
                                           urow.getAttribute("DocId");
                                
                                          urow.setAttribute("ReadAcceptFlag", "Y" );
                                         urow.getAttribute("ReadAcceptFlag");
                                
                                
//                                        OAMessageCheckBoxBean cb=(OAMessageCheckBoxBean)webBean.findChildRecursive("item91229");
//                                        System.out.println("Value of Check Box"+cb.getValue());
                                        am.invokeMethod("apply");
                                
                                HashMap hm=new HashMap();
                                hm.put("role", this.role);
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
      
      
 if ("delete".equals(pageContext.getParameter(EVENT_PARAM)))
 {
 // The user has clicked a "Delete" icon so we want to display a "Warning"
 // dialog asking if she really wants to delete the employee. Note that we
 // configure the dialog so that pressing the "Yes" button submits to
 // this page so we can handle the action in this processFormRequest( ) method.


  String rowReference = pageContext.getParameter(OAWebBeanConstants.EVENT_SOURCE_ROW_REFERENCE);    //Obtaining the Row Reference of the current Row
  System.out.println("Row Ref"+rowReference);         
  OARow row = (OARow)am.findRowByRef(rowReference);
     //    Serializable[] sn={(row.getAttribute("DocumentNumber")).toString(), (row.getAttribute("VersionNumber")).toString() };
  System.out.println(" row.getAttribute(\"DocumentNumber\")"+ row.getAttribute("DocumentNumber")+" row.getAttribute(\"DocumentNumber\")"+row.getAttribute("VersionNumber"));
  
  
     // dialog asking if she really wants to delete the employee. Note that we
     // configure the dialog so that pressing the "Yes" button submits to
     // this page so we can handle the action in this processFormRequest( )
   
     String docNo = (row.getAttribute("DocumentNumber")).toString();
     String docName = (row.getAttribute("DocumentName")).toString();
     String verNo = (row.getAttribute("VersionNumber")).toString();
     MessageToken[] tokens = { new MessageToken("DOC_NUM", docNo)};
     System.out.println("Tokens detect ed   efjasdflsjkf"+tokens);
     OAException mainMessage = new OAException("AK",
     "DELETE_MSG_MESSAGE", tokens);
     // Note that even though we're going to make our Yes/No buttons submit a
     // form, we still need some non-null value in the constructor's Yes/No
     // URL parameters for the buttons to render, so we just pass empty
     // Strings for this.
     OADialogPage dialogPage = new OADialogPage(OAException.WARNING,
     mainMessage, null, "", "");
     // Always use Message Dictionary for any Strings you want to display.
     String yes = pageContext.getMessage("AK", "FWK_TBX_T_YES", null);
     String no = pageContext.getMessage("AK", "FWK_TBX_T_NO", null);
     // We set this value so the code that handles this button press is
     // descriptive.
     dialogPage.setOkButtonItemName("DeleteYesButton");
     // The following configures the Yes/No buttons to be submit buttons,
     // and makes sure that we handle the form submit in the originating
     // page (the "Employee" summary) so we can handle the "Yes"
     // button selection in this controller.
     dialogPage.setOkButtonToPost(true);
     dialogPage.setNoButtonToPost(true);
     dialogPage.setPostToCallingPage(true);
     // Now set our Yes/No labels instead of the default OK/Cancel.
     dialogPage.setOkButtonLabel(yes);
     System.out.println("Something happens"+dialogPage);
     dialogPage.setNoButtonLabel(no);
     // We need to keep hold of the employeeNumber and employeeName.
     // The OADialogPage gives us a convenient means
     // of doing this. Note that the use of the Hashtable is
     // most appropriate for passing multiple parameters. See the OADialogPage
     // javadoc for an alternative when dealing with a single parameter.
     java.util.Hashtable formParams = new java.util.Hashtable(1);
 
     formParams.put("docNum", docNo);
     formParams.put("versNo", verNo);
     dialogPage.setFormParameters(formParams);
     pageContext.redirectToDialogPage(dialogPage);
 }
     
    
     if (pageContext.getParameter("DeleteYesButton") != null)
     {
     // User has confirmed that she wants to delete this employee.
     // Invoke a method on the AM to set the current row in the VO and
     // call remove() on this row.
     String docNumber = pageContext.getParameter("docNum");
     System.out.println("Doc numberfasdfjsdfkja"+docNumber);
     String docuName = pageContext.getParameter("docName");
         System.out.println("Doc   name"+docuName);
     String versionNo = pageContext.getParameter("versNo");
         System.out.println("Doc version No"+versionNo);
     Serializable[] parameters = { docNumber,  versionNo};
   System.out.println("Getting the params"+parameters);
   
     //Actually the parameters has to pass thro Dialog page But due to insufficient amount of time im hardcoding it
       
  
    am.invokeMethod("deleteRecord", parameters);  
     // Now, redisplay the page with a confirmation message at the top. Note
     // that the deleteEmployee() method in the AM commits, and our code
     // won't get this far if any exceptions are thrown.
//     MessageToken[] tokens = { new MessageToken("docName", employeeName) };
//     OAException message = new OAException("AK",
//     "FWK_TBX_T_EMP_DELETE_CONFIRM", tokens, OAException.CONFIRMATION, null);
//     pageContext.putDialogMessage(message);
     
  

      
       
     
     HashMap hm=new HashMap();
     hm.put("role", this.role);
     pageContext.setForwardURL("OA.jsp?page=/moiss/oracle/apps/fnd/moiss/webui/DocLibPG",
     null,
     //OAWebBeanConstants.KEEP_NO_DISPLAY_MENU_CONTEXT,
      OAWebBeanConstants.KEEP_NO_DISPLAY_MENU_CONTEXT,
     null,
     hm, 
     true,
     OAWebBeanConstants.ADD_BREAD_CRUMB_YES,
     OAWebBeanConstants.IGNORE_MESSAGES);
       
       
// String docNumber = pageContext.getParameter("DocumentNumber1");
// String verNumber = pageContext.getParameter("VersionNumber");
// 
// System.out.println("Values of Doc no and ver no"+docNumber+verNumber);
// MessageToken[] tokens = { new MessageToken("EMP_NAME", employeeName)};
 //OAException mainMessage = new OAException("AK", "FWK_TBX_T_EMP_DELETE_WARN", tokens);
 // Note that even though we're going to make our Yes/No buttons submit a
 // form, we still need some non-null value in the constructor's Yes/No
 // URL parameters for the buttons to render, so we just pass empty
 // Strings for this.
// OADialogPage dialogPage = new OADialogPage(OAException.WARNING, mainMessage, null, "", "");
 // Always use Message Dictionary for any Strings you want to display.
// String yes = pageContext.getMessage("AK", "FWK_TBX_T_YES", null);
// String no = pageContext.getMessage("AK", "FWK_TBX_T_NO", null);
//     System.out.println("Yes or  no"+docNumber+verNumber);
 // We set this value so the code that handles this button press is
 // descriptive.
 //dialogPage.setOkButtonItemName("DeleteYesButton");
 // The following configures the Yes/No buttons to be submit buttons,
 // and makes sure that we handle the form submit in the originating
 // page (the "Employee" summary) so we can handle the "Yes"
 // button selection in this controller.
// dialogPage.setOkButtonToPost(true);
// dialogPage.setNoButtonToPost(true);
// dialogPage.setPostToCallingPage(true);
 // Now set our Yes/No labels instead of the default OK/Cancel.
// dialogPage.setOkButtonLabel(yes);
// dialogPage.setNoButtonLabel(no);
 // We need to keep hold of the employeeNumber and employeeName.
 // The OADialogPage gives us a convenient means
 // of doing this. Note that the use of the Hashtable is
 // most appropriate for passing multiple parameters. See the OADialogPage
 // javadoc for an alternative when dealing with a single parameter.
// java.util.Hashtable formParams = new java.util.Hashtable(1);
// formParams.put("DocumentNumber", docNumber);
// formParams.put("VersionNumber", verNumber);
// dialogPage.setFormParameters(formParams);
// pageContext.redirectToDialogPage(dialogPage);
 }
 
 
////---------------------------------------------------------------------------------------------------------------------------------------------------------------------

       
//        pageContext.setForwardURLToCurrentPage(null, //      no parameters to pass
//
//           true, // retain the AM
//
//          OAWebBeanConstants.ADD_BREAD_CRUMB_NO,
//
//          OAWebBeanConstants.IGNORE_MESSAGES);
//
//        }
//   
//      
//        
////---------------------------------------------------------------------------------------------------------------------------------------------------------------------
//// Serializable[] param = {pageContext.getTemporaryImageLocation()};
//// pageContext.getApplicationModule(webBean).invokeMethod("initImg",param);
// 
//
//        /* Search when Find Button Clikced  */
////    if(cb.getValue()==)
////    
////    cb.setRendered(false);
////              
////            OATableBean tbb=(OATableBean)webBean.findChildRecursive("xxMoissDocLibVO1");
////            System.out.println(tbb);
////            tbb.queryData(pageContext);
//            //vo.getCurrentRow().getAttribute("DocumentName");
//
//             
//    //  OADefaultSingleColumnBean tb=(OADefaultSingleColumnBean)webBean.findChildRecursive("region11112");
// 
//            // OATableLayoutBean tb=(OATableLayoutBean)webBean.findChildRecursive("tble");
//           //  System.out.println("Values of table LAyout works"+tb);
//         
//       
//      // webBean.get
//             //x=tb.getChildNames();
////OARenderingContext k=pageContext.getRenderingContext();
//  ////           
//           //  System.out.println("Values of The Child count"+webBean.getIndexedChildCount());
//  //           
//             
// //     OAMessageTextInputBean tb=(OAMessageTextInputBean)webBean.getChildNames();
//  
// 
//      
////      System.out.println("Val of TB"+tb);
////      webBean.getAttributeNames(k);
////      x=tb.getChildNames();
////             int l=tb.getIndexedChildCount(k);
////             System.out.println("Indexed child for "+webBean.getIndexedChildCount());
////             System.out.println("Number of childern Associated is "+l);
////           //  System.out.println("Values in the variable to obtain table layout"+x);
//            
//            /*
// System.out.println("Document name Values"+pageContext.getParameter("DocumentName"));
// Enumeration x=null;
// x=pageContext.getParameterNames();
//          if(x!=null){
//          
//          System.out.println("Elements in Enum"+x);
//          while(x.hasMoreElements())
//          {
//          String aParamName = (String)x.nextElement();
//          System.out.println("Obatining the Child Names     : "+aParamName);
//          }
//            System.out.println("VO Gets Queried");
//            
//      }
//      */


             }
    }