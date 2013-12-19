/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package moiss.oracle.apps.fnd.moiss.webui;

import com.sun.java.util.collections.ArrayList;
import com.sun.java.util.collections.HashMap;
import com.sun.java.util.collections.Iterator;
import com.sun.java.util.collections.List;

import com.sun.java.util.collections.Map;

import java.util.Enumeration;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.OAViewObject;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.beans.OAImageBean;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.beans.layout.OAPopupBean;
import oracle.apps.fnd.framework.webui.beans.layout.OAStackLayoutBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageTextInputBean;
import oracle.apps.fnd.framework.webui.beans.table.OAAdvancedTableBean;

/**
 * Controller for ...
 */
public class MoissPICO extends OAControllerImpl
{
  public static final String RCS_ID="$Header$";
  public static final boolean RCS_ID_RECORDED =
        VersionInfo.recordClassVersion(RCS_ID, "%packagename%");

  /**
   * Layout and page setup logic for a region.
   * @param pageContext the current OA page context
   * @param webBean the web bean corresponding to the region
   */
  public void processRequest(OAPageContext pageContext, OAWebBean webBean)
  {
    super.processRequest(pageContext, webBean);
      OAApplicationModule am=(OAApplicationModule)pageContext.getApplicationModule(webBean);
         OAViewObject vo=(OAViewObject)am.findViewObject("MoissPIVO");
      System.out.println("Query gets Exe"+vo);
         vo.executeQuery();
         System.out.println("The totlal row count is "+vo.getRowCount());
       //  vo1.getCurrentRow().getAttribute("EmployeeNumber");
    
/*Logic for Popup*/
//      OAPopupBean popupBean =(OAPopupBean)createWebBean(pageContext,POPUP_BEAN,null,"myPopup");
//      //Set the following properties on the pop-up:
//      popupBean.setID("myPopup");
//      popupBean.setUINodeName("myPopup");
//      String popupRegion= "moiss/oracle/apps/fnd/moiss/webui/MoissUpdRN" ;
//      popupBean.setRegion(popupRegion);
//      popupBean.setHeight("130");
//      popupBean.setWidth("320");
//      popupBean.setTitle("Test");
//      popupBean.setType(EMBEDDED_POPUP);
//      System.out.println("Pop up has been added");
//      
//      
//      OAImageBean image = (OAImageBean)webBean.findChildRecursive("popupIMG");
//      image.setPopupEnabled(true);
//      image.setPopupRenderEvent("onClick");
//      System.out.println("Pop up has been added to an image");
//      image.setPopupID("myPopup"); 
//    
//    
//    OAAdvancedTableBean tableBean=(OAAdvancedTableBean)webBean.findChildRecursive("region3");
//      OAStackLayoutBean stackLayoutBean = new OAStackLayoutBean();
//      System.out.println("Pop up has been added Region has been added to stack");
//      stackLayoutBean.addIndexedChild(popupBean);
//      tableBean.addIndexedChild(stackLayoutBean); 
  }

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
         OAViewObject vo=(OAViewObject)am.findViewObject("MoissPIVO");
         
         
         
         
      if (pageContext.getParameter(EVENT_PARAM).equals("ClearButton"))
          {     
//              HashMap hm=new HashMap();  //Tried to send parameter through SetFowardURL
//               hm.put("keyparam", this.keyparam);
              
              pageContext.forwardImmediatelyToCurrentPage(null, false, "Y");   //Should check with the Admin paramter
              
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
         
       if (pageContext.getParameter(EVENT_PARAM).equals("Save"))
            {
            System.out.println("Event Occured");
            am.invokeMethod("apply");
            System.out.println("vo.getCurrentRow().getAttribute(\"EmployeeName\") ;"+vo.getCurrentRow().getAttribute("EmployeeName") );
            OAMessageTextInputBean ti=(OAMessageTextInputBean)webBean.findChildRecursive("EmployeeName123");
            System.out.println("ti.getValue(pageContext);"+ti.getValue(pageContext)); 
            System.out.println();
            System.out.println("Event Save   : --->");
            }
      if (pageContext.getParameter(EVENT_PARAM).equals("test"))
           {
                System.out.println("Value Testing for the check");
               OAMessageTextInputBean ti=(OAMessageTextInputBean)webBean.findChildRecursive("EmployeeName123");
               System.out.println("ti.getValue(pageContext);"+ti.getValue(pageContext)); 
               System.out.println("vo.getCurrentRow().getAttribute(\"EmployeeName\") ;"+vo.getCurrentRow().getAttribute("EmployeeName") );
           }
      if (pageContext.getParameter(EVENT_PARAM).equals("update"))
      {     
      
          
          //pageContext.forwardImmediatelyToCurrentPage(hm, false, "Y");
          
                //Parameters has been set in Image Item.. Look up for Reference
                
                
                System.out.println("Update Method called ");
                  pageContext.setForwardURL("OA.jsp?page=/moiss/oracle/apps/fnd/moiss/webui/UpdatePG",
                  null,
                  //OAWebBeanConstants.KEEP_NO_DISPLAY_MENU_CONTEXT,
                   OAWebBeanConstants.KEEP_NO_DISPLAY_MENU_CONTEXT,
                  null,
                  null, //HashMap
      
                  true,
                  OAWebBeanConstants.ADD_BREAD_CRUMB_YES,
                  OAWebBeanConstants.IGNORE_MESSAGES);
        
        
      }
      if (pageContext.getParameter(EVENT_PARAM).equals("Search"))
           {
//               Enumeration x=null;
//                x=pageContext.getParameterNames();
//                         if(x!=null){
//               
//                         System.out.println("Elements in Enum"+x);
//                         while(x.hasMoreElements())
//                         {
//                         String aParamName = (String)x.nextElement();
//                         System.out.println("Obatining the Child Names     : "+aParamName);
//                         }
//                           System.out.println("VO Gets Queried");
//               
//                     }
                
                
 
               List whClauseParams = new ArrayList();
               Map map = new HashMap();
               map.put("EMPLOYEE_NUMBER", pageContext.getParameter("EMPLOYEE_NUMBER"));
               map.put("EMPLOYEE_NAME", pageContext.getParameter("EMPLOYEE_NAME"));
               map.put("PUNCH_DATE", pageContext.getParameter("PUNCH_DATE"));
               map.put("DEPARTMENT", pageContext.getParameter("DEPARTMENT"));
               map.put("STATE", pageContext.getParameter("STATE"));
               Iterator entries = map.entrySet().iterator();
               while (entries.hasNext()) {
                   Map.Entry entry = (Map.Entry) entries.next();
                   String key = (String)entry.getKey();
                   String value = (String)entry.getValue();
                   System.out.println("Key = "+key+", Value = " + value);
                   
                   if (value != null && value != "") { 
                       try
                         {
                        // vo.setWhereClauseParam(0, pageContext.getParameter("DocumentName"));
                            whClauseParams.add(" and QRSLT."+key+" like '%"+value+"%'");
                         }
                         catch(Exception e){
                         System.out.println(e);
                         }
                   }
               }
                
                /*The below for loop will work in java but not here..... this is for Iteration ...*/
//                for(String temp : al)
//                {
//                        System.out.println(temp);
//                }

//               if (pageContext.getParameter("EmployeeName1") != null && pageContext.getParameter("EmployeeName1")!="") { 
//                   try
//                     {
//                    // vo.setWhereClauseParam(0, pageContext.getParameter("DocumentName"));
//                        whClauseParams.add(" and QRSLT.EMPLOYEE_NAME like '%"+pageContext.getParameter("EmployeeName1")+ "%'");
//                     }
//                     catch(Exception e){
//                     System.out.println(e);
//                     }
//               }
//               if (pageContext.getParameter("State1")!= null && pageContext.getParameter("State1")!="") { 
//                   try
//                     {
//                    // vo.setWhereClauseParam(0, pageContext.getParameter("DocumentName"));
//                        whClauseParams.add(" and QRSLT.STATE like '%"+pageContext.getParameter("State1")+ "%'");
//                     }
//                     catch(Exception e){
//                     System.out.println(e);
//                     }
//               }
//               if (pageContext.getParameter("Department1") != null &&pageContext.getParameter("Department1")!="") { 
//                   try
//                     {
//                    // vo.setWhereClauseParam(0, pageContext.getParameter("DocumentName"));
//                        whClauseParams.add(" and QRSLT.DEPARTMENT like '%"+pageContext.getParameter("Department1")+ "%'");
//                     }
//                     catch(Exception e){
//                     System.out.println(e);
//                     }
//               }
//               
//               
//
//               if (pageContext.getParameter("PunchDate1") != null && pageContext.getParameter("PunchDate1")!="") { 
//                   try
//                     {
//                    // vo.setWhereClauseParam(0, pageContext.getParameter("EffectiveStartDate"));
//                        whClauseParams.add(" and QRSLT.PUNCH_DATE like '%"+pageContext.getParameter("PunchDate1")+ "%' ");
//                     }
//                     catch(Exception e){
//                     System.out.println(e);
//                     }
//               }
//               
//               
//               




                 System.out.println("To check VO is not null"+vo);
                 
                if(vo!=null)
                {
              
                     String sqlparam=" ";
                     if(whClauseParams.isEmpty())
                    {
                                 System.out.println("No Params for Search");
                                 //vo.setOrderByClause("PUNCH_DATE desc");
                                 System.out.println("VO"+vo);
                                 vo.executeQuery();
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
                                         vo.setOrderByClause("PUNCH_DATE desc");
                                         vo.executeQuery();
                                     }
                       }
                 }
           }
  }

}
