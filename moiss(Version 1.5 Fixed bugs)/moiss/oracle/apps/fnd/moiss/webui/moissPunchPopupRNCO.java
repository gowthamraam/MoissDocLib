/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package moiss.oracle.apps.fnd.moiss.webui;

import com.sun.java.util.collections.HashMap;

import com.sun.java.util.collections.Iterator;
import com.sun.java.util.collections.Map;

import java.io.Serializable;

import java.sql.Date;

import java.text.SimpleDateFormat;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.OAViewObject;
import oracle.apps.fnd.framework.server.OADBTransaction;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.beans.layout.OADefaultDoubleColumnBean;
import oracle.apps.fnd.framework.webui.beans.layout.OADefaultSingleColumnBean;
import oracle.apps.fnd.framework.webui.beans.layout.OAHeaderBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageDateFieldBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageStyledTextBean;

import oracle.apps.fnd.framework.webui.beans.message.OAMessageTextInputBean;

import oracle.jbo.domain.Number;

/**
 * Controller for ...
 */
public class moissPunchPopupRNCO extends OAControllerImpl
{
  public static final String RCS_ID="$Header$";
  public static final boolean RCS_ID_RECORDED =
        VersionInfo.recordClassVersion(RCS_ID, "%packagename%");

  /**
   * Layout and page setup logic for a region.
   * @param pageContext the current OA page context
   * @param webBean the web bean corresponding to the region
   */
   String key=null;
   String tourl=null;
    String pref=null;
  public void processRequest(OAPageContext pageContext, OAWebBean webBean)
  {
    super.processRequest(pageContext, webBean);
    OAApplicationModule am=(OAApplicationModule)pageContext.getApplicationModule(webBean);
    Serializable[] sn={"MoissCIOVO"};
    am.invokeMethod("createRecord", sn);
    Serializable[] sn1={"MoissTempVO"};
    am.invokeMethod("createRecord", sn1);
    OAViewObject tvo=(OAViewObject)am.findViewObject("MoissTempVO");
    tvo.getCurrentRow().setAttribute("Upd", false);
    tvo.getCurrentRow().setAttribute("Cre", true);           
    tvo.getCurrentRow().setAttribute("Pref", false);
      tvo.getCurrentRow().setAttribute("Pref1", true);
    String key=pageContext.getParameter("key");
 
    tourl=pageContext.getParameter("urlPG");

    pref=pageContext.getParameter("pref")+"RN";           //For Showing whether we want the LOV Region or not
pref="INVLOVRN";
    this.pref=pref;
    if(pref.equals("INVLOVRN"))
    {
        tvo.getCurrentRow().setAttribute("Pref", true);
        tvo.getCurrentRow().setAttribute("Pref1", false);
        OAHeaderBean hb=(OAHeaderBean)webBean.findChildRecursive("region1");
         
    }
    this.tourl=tourl;
    //      key="UPDATE";
   key="CREATE";
    this.key=key;
    
    
    
      for(int i=1;i<=4;i++)
      {
      

      //---------------------------------------//          
                      /*Logic for Generating and Assigning In and Out for the Page to set Message Styled Text*/
                      
                           System.out.println("Inside for loop ");
                           String jI="In"+i;
                           String jO="Out"+i;
                           OAMessageStyledTextBean inn=(OAMessageStyledTextBean)webBean.findChildRecursive(jI);
                           inn.setValue(pageContext, jI);
                           OAMessageStyledTextBean outt=(OAMessageStyledTextBean)webBean.findChildRecursive(jO);
                           outt.setValue(pageContext, jO);
      }             
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------     
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------     

      /*For update  Functionality*/   
        if(key.equals("UPDATE"))
        {
            tvo.getCurrentRow().setAttribute("Upd", true);
            tvo.getCurrentRow().setAttribute("Cre", false);
            System.out.println("  Value of Upd Attr"+tvo.getCurrentRow().getAttribute("Upd"));
            System.out.println("  Value of Upd Attr"+tvo.getCurrentRow().getAttribute("Cre"));
          
           
             
//                hm.put("In1", "10:58");
//                hm.put("Out1", "11:10");
//                hm.put("In2", "11:58");
//           //     hm.put("Out2", "12:10");
//                hm.put("In3", "14:58");
//                hm.put("Out3", "15:58");
//        //      hm.put("In4", "16:58");
//                hm.put("Out4", "17:58");
//                hm.put("EmpName", "Gowtham");
//                hm.put("EmpNo", "285");
//                hm.put("Dept", "OPERATIONS");
//                hm.put("DateFieldItem","17-Dec-2013");
                
 //             Dont know why After using Iterator im not able to get the values        
//                Iterator it = hm.entrySet().iterator();
//                while (it.hasNext()) {
//                    Map.Entry pairs = (Map.Entry)it.next();
//                    System.out.println(pairs.getKey() + " = " + pairs.getValue());
//                    it.remove(); // avoids a ConcurrentModificationException
//                }
            
            HashMap hm=new HashMap();  
            hm.put("In1",  pageContext.getParameter("In1"));
            hm.put("Out1",  pageContext.getParameter("Out1"));
            hm.put("In2",  pageContext.getParameter("In2"));
            hm.put("Out2",  pageContext.getParameter("Out2"));
            hm.put("In3",  pageContext.getParameter("In3"));
            hm.put("Out3",  pageContext.getParameter("Out3"));
            hm.put("In4",  pageContext.getParameter("In4"));
            hm.put("Out4",  pageContext.getParameter("Out4"));
            hm.put("EmpName", pageContext.getParameter("EmpName"));
            hm.put("EmpNo", pageContext.getParameter("EmpNo"));
            hm.put("Dept",  pageContext.getParameter("Dept"));
            hm.put("DateFieldItem",pageContext.getParameter("DateFieldItem"));
                
                
                
                
            System.out.println("hm.get(\"EmpName\")"+hm.get("EmpName"));
            System.out.println("hm.get(\"EmpName\")"+hm.get("EmpNo"));
            System.out.println("hm.get(\"EmpName\")"+ hm.get("Dept"));
            System.out.println("hm.get(\"EmpName\")"+hm.get("DateFieldItem"));
            
            
            if(hm.get("EmpName")!=null)
            {
                OAMessageStyledTextBean tb1=(OAMessageStyledTextBean)webBean.findChildRecursive("EmpName1");
               tb1.setValue(pageContext, hm.get("EmpName"));
            }
            if(hm.get("EmpNo") !=null)
            {
                OAMessageStyledTextBean tb1=(OAMessageStyledTextBean)webBean.findChildRecursive("EmpNo1");
                tb1.setValue(pageContext, hm.get("EmpNo"));
            }
             if( hm.get("Dept") !=null)
            {
                OAMessageStyledTextBean tb1=(OAMessageStyledTextBean)webBean.findChildRecursive("Dept1");
                tb1.setValue(pageContext, hm.get("Dept") );
            }
            if(hm.get("DateFieldItem") !=null)
            {
                OAMessageStyledTextBean tb1=(OAMessageStyledTextBean)webBean.findChildRecursive("DateFieldItem1");
                tb1.setValue(pageContext, hm.get("DateFieldItem"));
            }
            
    //          /*Dint Work                */
    //        System.out.println("Output Method #2 ");
    //              for (String key : hm.keySet()) {
    //                  System.out.println("Key = " + key);
    //              }
    //        
    //              //Part #2 iterating over values only
    //              for (String value : hm.values()) {
    //                  System.out.println("Value = " + value);
    //              }
    
    
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------     

            /*for loop runs which has two logics to run below inside the comment we have the logic's code*/
            for(int i=1;i<=4;i++)
            {
            

//--------------------------------------//      
                /*Logic for checking whether any value is in In1 or Out1 till In4 and out4. If value exists the value will be in MessageStyledText, If there is no value it will be as MessageTextInput*/
            
                if(hm.get("In"+i)!=null)            
                {
                    System.out.println("Inside Loop for input"+"MCin"+i+"1");    
                    OAMessageStyledTextBean jni=(OAMessageStyledTextBean)webBean.findChildRecursive("MCin"+i+"1");
                    jni.setRendered(true);           //   Setting true when value exists
                    jni.setViewUsageName("MoissTempVO");        //Changing the View attribute so that i will not get any interuption.. This was done when i got a issue of the values which has the same VO
                    jni.setViewAttributeName("Attr"+i);            //Setting the view atttribute
                    OAMessageTextInputBean jni1=(OAMessageTextInputBean)webBean.findChildRecursive("MCin"+i);
                    jni1.setRendered(false);          //   Setting false for Message text input
                    System.out.println("Inside Loop for input"+jni+"MCin"+i+"1"); 
                    System.out.println("hm.get(\"In1\")"+hm.get("In1"));
                    jni.setValue(pageContext, hm.get("In"+i));
             //       jni.setValue(pageContext, "gfg");
                    jni.setRendered(true);
                }    
                else
                {
                    OAMessageTextInputBean jni1=(OAMessageTextInputBean)webBean.findChildRecursive("MCin"+i);
                    jni1.setRendered(true);
                    OAMessageStyledTextBean jni2=(OAMessageStyledTextBean)webBean.findChildRecursive("MCin"+i+"1");
                    jni2.setRendered(false);
                }
                if(hm.get("Out"+i)!=null)            
                {
                    System.out.println("Inside Loop for output");
                    OAMessageStyledTextBean jno=(OAMessageStyledTextBean)webBean.findChildRecursive("MCout"+i+"1");
                    jno.setRendered(true);
                    jno.setViewUsageName("MoissTempVO");
                    jno.setViewAttributeName("Attr"+i);
                    OAMessageTextInputBean jni1=(OAMessageTextInputBean)webBean.findChildRecursive("MCout"+i);
                    jni1.setRendered(false);
                    System.out.println("Inside Loop for output"+jno+("Out"+i));  
                    jno.setValue(pageContext,  hm.get("Out"+i));
                    jno.setRendered(true);
                }  
                else
                {
                    OAMessageTextInputBean jni1=(OAMessageTextInputBean)webBean.findChildRecursive("MCout"+i);
                    jni1.setRendered(true);
                    OAMessageStyledTextBean jni2=(OAMessageStyledTextBean)webBean.findChildRecursive("MCout"+i+"1");
                    jni2.setRendered(false);
                }
            }           //for loop ends here
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------     

    
        }
        /*If not update automatically enable the create Functionality*/
        else
        {
            tvo.getCurrentRow().setAttribute("Upd", false);
            tvo.getCurrentRow().setAttribute("Cre", true);
        }
         
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------     
          
    
          
    
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
          
          
          /*Logic for Dynamically creating the attributes (stopped and should be developed)(Not upto Development Stage) */
          
    //      pageContext.getParameter("");
    //       
    //       
    //       
    // for(int i=1;i<=4;i++)
    // {
    //    System.out.println("inside the second for loop testing ");
    //     OADefaultDoubleColumnBean  cio=(OADefaultDoubleColumnBean)webBean.findIndexedChildRecursive("Cio"+i); // Initialization of Default Single Column 
    //     OAMessageTextInputBean mtbi=(OAMessageTextInputBean)createWebBean(pageContext,OAWebBeanConstants.MESSAGE_TEXT_INPUT_BEAN,null,"MCinn"+i);
    //     OAMessageTextInputBean mtbo=(OAMessageTextInputBean)createWebBean(pageContext,OAWebBeanConstants.MESSAGE_TEXT_INPUT_BEAN,null,"MCoutt"+i);
    //     mtbi.setViewUsageName("MoissCIOVO");
    //     mtbi.setViewAttributeName("Cin"+i);
    //     mtbo.setViewUsageName("MoissCIOVO");
    //     mtbo.setViewAttributeName("Cout"+i);
    //     mtbi.setRendered(true);
    //  //   mtbi.setViewUsageName("MoissCIOVO");
    //    /*Creation MessagetextInputBean And Setting Prompt */
    //     cio.addIndexedChild(mtbi);// adding item to the StackLayout
    //     cio.addIndexedChild(mtbo);// adding item to the StackLayout
    //     
    //      System.out.println("inside the second for loop testing "+mtbi+mtbo+cio);
    // }
    // 
     
     
     
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
           
           
           
          OAViewObject cvo1=(OAViewObject)am.findViewObject("MoissCIOVO");
          cvo1.getCurrentRow().setAttribute("RowNumber", "1");
    
          System.out.println("cvo1.getCurrentRow().getAttribute(\"RowNumber\")"+cvo1.getCurrentRow().getAttribute("RowNumber"));

  }

  /**
   * Procedure to handle form submissions for form elements in
   * a region.
   * @param pageContext the current OA page context
   * @param webBean the web bean corresponding to the region
   */
   
   int vCount=0;
   int cCount=0;
    int cCount1=0;
    int cCount2=0;
    int cCount3=0;
    int cCount4=0;
    String dtfor=null;
    String t1;
    String t2;
    String t3;
    String t4;
    String t5;
    String t6;
    String t7;
    String t8;
    String t9;
    int countr=0;
    
  public void processFormRequest(OAPageContext pageContext, OAWebBean webBean)
  {
    super.processFormRequest(pageContext, webBean);
      OAApplicationModule am=(OAApplicationModule)pageContext.getApplicationModule(webBean);                //Getting AM Object
      OAViewObject cvo=(OAViewObject)am.findViewObject("MoissCIOVO");                                       //Obtaining Transient VO for saving in Eight rows
      OADBTransaction txn =(OADBTransaction)am.getOADBTransaction();

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------       
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
       if(key.equals("UPDATE"))
       {
    
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
          /*Logic for changing the Date Format*/
                    
                  SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");   //old format
                  SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");   //new format
                  OAMessageStyledTextBean ti=(OAMessageStyledTextBean)webBean.findChildRecursive("DateFieldItem1");
                  String dt=(ti.getValue(pageContext)).toString();   //Getting the date
                  System.out.println("ti--------=============-------------============--------->"+dt);
                  try{
                  System.out.println("sdf.parse(dt)====>"+sdf.parse(dt));
                           java.util.Date aj =sdf.parse(dt);                //Changing the String to Date with format
                           this.dtfor=sdf1.format(aj);                      //Conversion takes place
                            
                            System.out.println("dtfor"+dtfor);
                 }
                 catch(Exception e)                                         //parse method throws Parse Exception
                 {
                         System.out.println("Exception Occured"+e);
                 }
                 System.out.println("Second test for dtfor"+dt+dtfor);
                 this.dtfor=dtfor;                                          //Setting the value for this as it can be accessed anywhere

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------    
          
           System.out.println(  ((OAMessageTextInputBean)webBean.findChildRecursive("MCout1")).getValue(pageContext)+"  ((OAMessageTextInputBean)webBean.findChildRecursive(\"MCin1\")).getValue(pageContext)");  //Checking for the value whether the field is null or not
           System.out.println(((OAMessageTextInputBean)webBean.findChildRecursive("MCin1")).getValue(pageContext)+"((OAMessageTextInputBean)webBean.findChildRecursive(\"MCin1\")).getValue(pageContext)");

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------    
        
           if(  ((OAMessageTextInputBean)webBean.findChildRecursive("MCin1")).getValue(pageContext)==null||((OAMessageTextInputBean)webBean.findChildRecursive("MCin1")).getValue(pageContext).equals(""))               // Checking for the value whether if value exists or not. If exists this creates a row in VO and gets inserted(This takes high cost due to so many objects interactions and casting needed to rewrite)
           {
                System.out.println("Contains Some value"+pageContext.getParameter("MCin11"));
                System.out.println("Inside Sector 1");
           }
           else
           {
           System.out.println("Inside Sector 1 else");
               OAViewObject vo1=(OAViewObject)am.findViewObject("MoissPInfoVO1");         //Defining View Objects        
               Serializable[] sn={"MoissPInfoVO1"};                                       
               am.invokeMethod("createRecord", sn);                                     //Creating Row
               Number seqNum=txn.getSequenceValue("MOISS_PUNCH_INFO_ID_S");            //Obtaining Sequence for First row
               
               vo1.getCurrentRow().setAttribute("PunchInfoId", seqNum);
               vo1.getCurrentRow().setAttribute("PunchCode", "M1");
               vo1.getCurrentRow().setAttribute("EmployeeNumber", ((OAMessageStyledTextBean)webBean.findChildRecursive("EmpNo1")).getValue(pageContext));
               vo1.getCurrentRow().setAttribute("EmployeeName", ((OAMessageStyledTextBean)webBean.findChildRecursive("EmpName1")).getValue(pageContext));
               vo1.getCurrentRow().setAttribute("Department", ((OAMessageStyledTextBean)webBean.findChildRecursive("Dept1")).getValue(pageContext) );
               vo1.getCurrentRow().setAttribute("ManEntryYn", "Y");          
               vo1.getCurrentRow().setAttribute("State", "Cin");    
               
               String o=(cvo.getCurrentRow().getAttribute("Cin1")).toString();   //Logic for converting the Hours to minutes and setting in VO
               int oo=Integer.parseInt(o.substring(0,2));
               System.out.println(""+oo);   
               if(oo > 12)
               {
                   t1=""+(oo-12)+o.substring(2)+" PM";
                   this.t1=t1;
                   System.out.println("The Value of T for Validation is "+t1);
               }
               else
               {
                   t1=""+(oo)+o.substring(2)+" AM";
                   this.t1=t1;
                   System.out.println("The Value of T for Validation is "+t1);
               
               }
               vo1.getCurrentRow().setAttribute("PunchDate", dtfor+" "+t1); 
               this.countr=countr+1;
               System.out.println("Countr is incremented at sector 1");
           }
           if( ((OAMessageTextInputBean)webBean.findChildRecursive("MCout1")).getValue(pageContext)==null)                                                //Logic for Commit / Save
           {
               System.out.println("Contains Some value"+pageContext.getParameter("MCout11"));
               System.out.println("Inside Sector 2");
           } 
           else
           {
               System.out.println("Inside Sector 2 else");
               OAViewObject vo2=(OAViewObject)am.findViewObject("MoissPInfoVO2"); 
               Serializable[] sn1={"MoissPInfoVO2"};
               am.invokeMethod("createRecord", sn1);                
               Number seqNum1=txn.getSequenceValue("MOISS_PUNCH_INFO_ID_S");           //Obtaining Sequence for Second row 
               
               vo2.getCurrentRow().setAttribute("PunchCode", "M1");
               vo2.getCurrentRow().setAttribute("PunchInfoId", seqNum1);
               vo2.getCurrentRow().setAttribute("EmployeeNumber", ((OAMessageStyledTextBean)webBean.findChildRecursive("EmpNo1")).getValue(pageContext));
               vo2.getCurrentRow().setAttribute("EmployeeName", ((OAMessageStyledTextBean)webBean.findChildRecursive("EmpName1")).getValue(pageContext));
               vo2.getCurrentRow().setAttribute("Department", ((OAMessageStyledTextBean)webBean.findChildRecursive("Dept1")).getValue(pageContext) );
               vo2.getCurrentRow().setAttribute("ManEntryYn", "Y");          
               vo2.getCurrentRow().setAttribute("State", "Cout");
               String o=(cvo.getCurrentRow().getAttribute("Cout1")).toString();
               int   oo=Integer.parseInt(o.substring(0,2));
               System.out.println(""+oo);
               if(oo > 11)
               {
                   t2=""+(oo-12)+o.substring(2)+" PM";
                   this.t2=t2;
                   System.out.println("The Value of T for Validation is "+t2);
               }
               else
               {
                   t2=""+(oo)+o.substring(2)+" AM";
                   this.t2=t2;
                   System.out.println("The Value of T for Validation is "+t2);
               
               }
               vo2.getCurrentRow().setAttribute("PunchDate", dtfor+" "+t2);
               this.countr=countr+1;
               System.out.println("Countr is incremented at sector 2");
               
           }
           if( ((OAMessageTextInputBean)webBean.findChildRecursive("MCin2")).getValue(pageContext)==null|| ((OAMessageTextInputBean)webBean.findChildRecursive("MCin2")).getValue(pageContext).equals(""))                                                //Logic for Commit / Save
           {
               System.out.println("Contains Some value"+pageContext.getParameter("MCin21"));
               System.out.println("Inside Sector 3");
           }
           else
           {
               System.out.println("Inside Sector 3 else");
               OAViewObject vo3=(OAViewObject)am.findViewObject("MoissPInfoVO3");
               Serializable[] sn={"MoissPInfoVO3"};
               am.invokeMethod("createRecord", sn);
               Number seqNum=txn.getSequenceValue("MOISS_PUNCH_INFO_ID_S");
               
               vo3.getCurrentRow().setAttribute("PunchInfoId", seqNum);
               vo3.getCurrentRow().setAttribute("PunchCode", "M1");
               vo3.getCurrentRow().setAttribute("EmployeeNumber", ((OAMessageStyledTextBean)webBean.findChildRecursive("EmpNo1")).getValue(pageContext));
               vo3.getCurrentRow().setAttribute("EmployeeName", ((OAMessageStyledTextBean)webBean.findChildRecursive("EmpName1")).getValue(pageContext));
               vo3.getCurrentRow().setAttribute("Department", ((OAMessageStyledTextBean)webBean.findChildRecursive("Dept1")).getValue(pageContext) );
               vo3.getCurrentRow().setAttribute("ManEntryYn", "Y");          
               vo3.getCurrentRow().setAttribute("State", "Cin");
               String o=(cvo.getCurrentRow().getAttribute("Cin2")).toString();
               int oo=Integer.parseInt(o.substring(0,2));
               System.out.println(""+oo);
               if(oo > 12)
               {
                   t3=""+(oo-12)+o.substring(2)+" PM";
                   this.t3=t3;
                   System.out.println("The Value of T for Validation is "+t3);
               }
               else
               {
                   t3=""+(oo)+o.substring(2)+" AM";
                   this.t3=t3;
                   System.out.println("The Value of T for Validation is "+t3);
               
               }
               vo3.getCurrentRow().setAttribute("PunchDate", dtfor+" "+t3); 
               this.countr=countr+1;
               System.out.println("Countr is incremented at sector 3");
               
           }
           if(((OAMessageTextInputBean)webBean.findChildRecursive("MCout2")).getValue(pageContext)==null||((OAMessageTextInputBean)webBean.findChildRecursive("MCout2")).getValue(pageContext).equals(""))                                                //Logic for Commit / Save
           {
               System.out.println("Contains Some value"+pageContext.getParameter("MCout21"));
               System.out.println("Inside Sector 4");
           }
           else
           {
               System.out.println("Inside Sector 4");
                              OAViewObject vo4=(OAViewObject)am.findViewObject("MoissPInfoVO4");
                              Serializable[] sn1={"MoissPInfoVO4"};
                              am.invokeMethod("createRecord", sn1);
                              Number seqNum1=txn.getSequenceValue("MOISS_PUNCH_INFO_ID_S");
                              
                              vo4.getCurrentRow().setAttribute("PunchCode", "M1");
                              vo4.getCurrentRow().setAttribute("PunchInfoId", seqNum1);
                              vo4.getCurrentRow().setAttribute("EmployeeNumber", ((OAMessageStyledTextBean)webBean.findChildRecursive("EmpNo1")).getValue(pageContext));
                              vo4.getCurrentRow().setAttribute("EmployeeName", ((OAMessageStyledTextBean)webBean.findChildRecursive("EmpName1")).getValue(pageContext));
                              vo4.getCurrentRow().setAttribute("Department", ((OAMessageStyledTextBean)webBean.findChildRecursive("Dept1")).getValue(pageContext) );
                              vo4.getCurrentRow().setAttribute("ManEntryYn", "Y");          
                              vo4.getCurrentRow().setAttribute("State", "Cout");
                              String o=(cvo.getCurrentRow().getAttribute("Cout2")).toString();
                              System.out.println("Value of O is for Cout 2"+o);
                              int oo=Integer.parseInt(o.substring(0,2));
                              System.out.println("Value of oo is for Cout 2"+oo);
                              System.out.println(""+oo);
                              if(oo > 11)
                              {
                                  t4=""+(oo-12)+o.substring(2)+" PM";
                                  this.t4=t4;
                                  System.out.println("The Value of T for Validation is "+t4);
                              }
                              else
                              {
                                  t4=""+(oo)+o.substring(2)+" AM";
                                  this.t4=t4;
                                  System.out.println("The Value of T for Validation is "+t4);
                              
                              }
                              vo4.getCurrentRow().setAttribute("PunchDate", dtfor+" "+t4);
                              System.out.println("Testing for Field "+cvo.getCurrentRow().getAttribute("Cout2"));
               this.countr=countr+1;
               
               System.out.println("Countr is incremented at sector 4");
           }
           if( ((OAMessageTextInputBean)webBean.findChildRecursive("MCin3")).getValue(pageContext)==null|| ((OAMessageTextInputBean)webBean.findChildRecursive("MCin3")).getValue(pageContext).equals(""))                                                //Logic for Commit / Save
           {
               System.out.println("Contains Some value"+pageContext.getParameter("MCin31"));
               System.out.println("Inside Sector 5");
           }
           else
           {
               System.out.println("Inside Sector 5 else");
               OAViewObject vo5=(OAViewObject)am.findViewObject("MoissPInfoVO5");
               Serializable[] sn={"MoissPInfoVO5"};
               am.invokeMethod("createRecord", sn);
               Number seqNum=txn.getSequenceValue("MOISS_PUNCH_INFO_ID_S");
               
               vo5.getCurrentRow().setAttribute("PunchInfoId", seqNum);
               vo5.getCurrentRow().setAttribute("PunchCode", "M1");
               vo5.getCurrentRow().setAttribute("EmployeeNumber", ((OAMessageStyledTextBean)webBean.findChildRecursive("EmpNo1")).getValue(pageContext));
               vo5.getCurrentRow().setAttribute("EmployeeName", ((OAMessageStyledTextBean)webBean.findChildRecursive("EmpName1")).getValue(pageContext));
               vo5.getCurrentRow().setAttribute("Department", ((OAMessageStyledTextBean)webBean.findChildRecursive("Dept1")).getValue(pageContext) );
               vo5.getCurrentRow().setAttribute("ManEntryYn", "Y");          
               vo5.getCurrentRow().setAttribute("State", "Cin");
               String o=(cvo.getCurrentRow().getAttribute("Cin3")).toString();
               int oo=Integer.parseInt(o.substring(0,2));
               
               System.out.println("The Value of 3 oo and o is "+oo+"Na"+o);
               if(oo > 12)
               {
                   t5=""+(oo-12)+o.substring(2)+" PM";
                   this.t5=t5;
                   System.out.println("The Value of T for Validation is "+t5);
               }
               else
               {
                   t5=""+(oo)+o.substring(2)+" AM";
                   this.t5=t5;
                   System.out.println("The Value of T for Validation is "+t5);
               }
               vo5.getCurrentRow().setAttribute("PunchDate", dtfor+" "+t5);
               this.countr=countr+1;
               System.out.println("Countr is incremented at sector 5");
                    
           }
           if(((OAMessageTextInputBean)webBean.findChildRecursive("MCout3")).getValue(pageContext)==null||((OAMessageTextInputBean)webBean.findChildRecursive("MCout3")).getValue(pageContext).equals(""))                                                //Logic for Commit / Save
           {
               System.out.println("Contains Some value"+pageContext.getParameter("MCout31"));
               System.out.println("Inside Sector 6");
           }
           else
           {
               System.out.println("Inside Sector 6");
               OAViewObject vo6=(OAViewObject)am.findViewObject("MoissPInfoVO6");
               Serializable[] sn1={"MoissPInfoVO6"};
               am.invokeMethod("createRecord", sn1);
               Number seqNum1=txn.getSequenceValue("MOISS_PUNCH_INFO_ID_S");         
               
               vo6.getCurrentRow().setAttribute("PunchCode", "M1");
               vo6.getCurrentRow().setAttribute("PunchInfoId", seqNum1);
               vo6.getCurrentRow().setAttribute("EmployeeNumber", ((OAMessageStyledTextBean)webBean.findChildRecursive("EmpNo1")).getValue(pageContext));
               vo6.getCurrentRow().setAttribute("EmployeeName", ((OAMessageStyledTextBean)webBean.findChildRecursive("EmpName1")).getValue(pageContext));
               vo6.getCurrentRow().setAttribute("Department", ((OAMessageStyledTextBean)webBean.findChildRecursive("Dept1")).getValue(pageContext) );
               vo6.getCurrentRow().setAttribute("ManEntryYn", "Y");          
               vo6.getCurrentRow().setAttribute("State", "Cout");
               String  o=(cvo.getCurrentRow().getAttribute("Cout3")).toString();
                 int oo=Integer.parseInt(o.substring(0,2));
               System.out.println(""+oo);
               if(oo > 11)
               {
                   t6=""+(oo-12)+o.substring(2)+" PM";
                   this.t6=t6;
                   System.out.println("The Value of T for Validation is "+t6);
               }
               else
               {
                   t6=""+(oo)+o.substring(2)+" AM";
                   this.t6=t6;
                   System.out.println("The Value of T for Validation is "+t6);
               
               }
               vo6.getCurrentRow().setAttribute("PunchDate", dtfor+" "+t6);
               this.countr=countr+1;
               System.out.println("Countr is incremented at sector 6");
           }
           if( ((OAMessageTextInputBean)webBean.findChildRecursive("MCin4")).getValue(pageContext)==null|| ((OAMessageTextInputBean)webBean.findChildRecursive("MCin4")).getValue(pageContext).equals(""))                                                //Logic for Commit / Save
           {
               System.out.println("Contains Some value"+pageContext.getParameter("MCin41"));
               System.out.println("Inside Sector 7");
           }
           else
           {
               System.out.println("Inside Sector 7 else");
               OAViewObject vo7=(OAViewObject)am.findViewObject("MoissPInfoVO7");
               Serializable[] sn={"MoissPInfoVO7"};
               am.invokeMethod("createRecord", sn);
               Number seqNum=txn.getSequenceValue("MOISS_PUNCH_INFO_ID_S");
               
               vo7.getCurrentRow().setAttribute("PunchInfoId", seqNum);
               vo7.getCurrentRow().setAttribute("PunchCode", "M1");
               vo7.getCurrentRow().setAttribute("EmployeeNumber", ((OAMessageStyledTextBean)webBean.findChildRecursive("EmpNo1")).getValue(pageContext));
               vo7.getCurrentRow().setAttribute("EmployeeName", ((OAMessageStyledTextBean)webBean.findChildRecursive("EmpName1")).getValue(pageContext));
               vo7.getCurrentRow().setAttribute("Department", ((OAMessageStyledTextBean)webBean.findChildRecursive("Dept1")).getValue(pageContext) );
               vo7.getCurrentRow().setAttribute("ManEntryYn", "Y");          
               vo7.getCurrentRow().setAttribute("State", "Cin");
               
               String o=(cvo.getCurrentRow().getAttribute("Cin4")).toString();
               int oo=Integer.parseInt(o.substring(0,2));
               System.out.println(""+oo);
               if(oo > 12)
               {
                   t7=""+(oo-12)+o.substring(2)+" PM";
                   this.t7=t7;
                   System.out.println("The Value of T for Validation is "+t7);
               }
               else
               {
                   t7=""+(oo)+o.substring(2)+" AM";
                   this.t7=t7;
                   System.out.println("The Value of T for Validation is "+t7);            
               }
               vo7.getCurrentRow().setAttribute("PunchDate", dtfor+" "+t7); 
               this.countr=countr+1;
               System.out.println("Countr is incremented at sector 7");
           }
           if(((OAMessageTextInputBean)webBean.findChildRecursive("MCout4")).getValue(pageContext)==null||((OAMessageTextInputBean)webBean.findChildRecursive("MCout4")).getValue(pageContext).equals(""))                                                //Logic for Commit / Save
           {
               System.out.println("Contains Some value"+pageContext.getParameter("MCout41"));
               System.out.println("Inside Sector 8");
           }
           else
           {    
               System.out.println("Inside Sector 8");
               OAViewObject vo8=(OAViewObject)am.findViewObject("MoissPInfoVO8");
               Serializable[] sn1={"MoissPInfoVO8"};
               am.invokeMethod("createRecord", sn1);
               Number seqNum1=txn.getSequenceValue("MOISS_PUNCH_INFO_ID_S");
               
               vo8.getCurrentRow().setAttribute("PunchCode", "M1");
               vo8.getCurrentRow().setAttribute("PunchInfoId", seqNum1);
               vo8.getCurrentRow().setAttribute("EmployeeNumber", ((OAMessageStyledTextBean)webBean.findChildRecursive("EmpNo1")).getValue(pageContext));
               vo8.getCurrentRow().setAttribute("EmployeeName", ((OAMessageStyledTextBean)webBean.findChildRecursive("EmpName1")).getValue(pageContext));
               vo8.getCurrentRow().setAttribute("Department", ((OAMessageStyledTextBean)webBean.findChildRecursive("Dept1")).getValue(pageContext) );
               vo8.getCurrentRow().setAttribute("ManEntryYn", "Y");          
               vo8.getCurrentRow().setAttribute("State", "Cout");
               String o=(cvo.getCurrentRow().getAttribute("Cout4")).toString();
               int oo=Integer.parseInt(o.substring(0,2));
               System.out.println(""+oo);
               if(oo > 11)
               {
                   t8=""+(oo-12)+o.substring(2)+" PM";
                   this.t8=t8;
                   System.out.println("The Value of T for Validation is "+t8);
               }
               else
               {
                   t8=""+(oo)+o.substring(2)+" AM";
                   this.t8=t8;
                   System.out.println("The Value of T for Validation is "+t8);
               
               }
               vo8.getCurrentRow().setAttribute("PunchDate", dtfor+" "+t8); 
               this.countr=countr+1;
               System.out.println("Countr is incremented at sector 8");
           }
           
           
           
            if(countr>=1) //Checking whether there had been a increment in any text box. If any the value gets Commited 
            {
                System.out.println("Under Commit");
                OAException confirmMessage = new OAException("Record Has Been Saved", OAException.CONFIRMATION);
                pageContext.putDialogMessage(confirmMessage);
                am.invokeMethod("apply");
            }
  
       }//End of update to happen
       
       
       
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------       
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
      
       /*Logic for Create page where the fucntionality is handled seperatly. Need to merge and make code cleanups*/
       
       
       else
       {
          
      if(pageContext.getParameter(EVENT_PARAM).equals("updatefordate"))                                                //Logic for Commit / Save
      {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
       SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy"); 

              OAMessageDateFieldBean ti=(OAMessageDateFieldBean)webBean.findChildRecursive("DateFieldItem");
               String dt=(ti.getValue(pageContext)).toString();   
               System.out.println("ti--------=============-------------============--------->"+ti);
               try{
                        java.util.Date aj =(sdf.parse(dt));
                         this.dtfor=sdf1.format(aj);
              }
              catch(Exception e)
              {
                      System.out.println("Exception Occured"+e);
              }
              System.out.println("Second test for dtfor"+dt+dtfor);
              this.dtfor=dtfor;

     }
      if(pageContext.getParameter(EVENT_PARAM).equals("Save"))                                                //Logic for Commit / Save
      {
            System.out.println("Event Fired for save");
        
        
      /*Test*/
//      System.out.println("Insidte date--------------------------------------------------------------------->");
//      //String dt=(cvo.getCurrentRow().getAttribute("Date")).toString() ;
//      System.out.println("Value of Dt for texasdfjashl----------------------------------------------------->"+dt);
////      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");      SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
//      //
//      try{
//      java.util.Date aj =(sdf.parse(dt));
//      this.dtfor=sdf1.format(aj);
//      
//      }
//      catch(Exception e)
//      {
//             System.out.println("Exception Occured"+e);
//      }
//      
//      System.out.println("First test for dtfor"+dt+dtfor);
//      this.dtfor=dtfor;
//      
      /*Test*/
      //            OAMessageDateFieldBean ti=(OAMessageDateFieldBean)webBean.findChildRecursive("DateFieldItem");
      //             String dt=(ti.getValue(pageContext)).toString();
      //        DateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
      //
      //String currdate1=dt;
      //
      //
      //
      //
      //             try{
      //            this.dtfor=(sdf.parse(dt)).toString();
      //             java.util.Date   cdate = (java.util.Date)formatter1.parse(currdate1);   //Gets converted
      //             System.out.println("ouptu asdfjklahsdfjkha---------------------------------->"+cdate);
      //            }
      //            catch(Exception e)
      //            {
      //                    System.out.println("Exception Occured"+e);
      //            }
      //            System.out.println("Second test for dtfor"+dt+dtfor);
      //            this.dtfor=dtfor;
      //
       
        //dateCal.add(Calendar.DAY_OF_MONTH,31);

        //dt = dateCal.getTime();

        //  writeLog(XXPO_APP_SHORT_NAME,pageContext,”End date “+dt);  //To have a log(History)

        //actionDateText.setMaxValue(dt);
            
            //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            /*Logic for checking the columns as not null*/
            if((pageContext.getParameter("EmpNo")!=null)&&(pageContext.getParameter("EmpNo").equals(""))&&(pageContext.getParameter("EmpName")!=null)&&(pageContext.getParameter("EmpName").equals(""))&&(pageContext.getParameter("Dept")!=null)&&(pageContext.getParameter("Dept").equals(""))&&(pageContext.getParameter("Date")!=null)&&(pageContext.getParameter("Date").equals("")))
            {
                   System.out.println("Invalid");
            }
            else
            {
                    System.out.println("Valid");
                vCount=vCount+1;
                this.vCount=vCount;
            }
      //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                /* Logic for automating the Punch Entry and it is currently under development*/
      //            for(int j=0;j>=4;j++)
      //            {
      //                String k= "(pageContext.getParameter(\"MCin"+j+"\")!=null)&&pageContext.getParameter(\"MCin"+j+"\").equals(\"\")&&pageContext.getParameter(\"MCout"+j+"\")!=null&&pageContext.getParameter(\"MCout"+j+"1\").equals(\"\")";
      //            }
      //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                /*Logic For checking the In or out Is not at right range*/
            if((pageContext.getParameter("MCin1")!=null)&&pageContext.getParameter("MCin1").equals("")&&pageContext.getParameter("MCout1")!=null&&pageContext.getParameter("MCout1").equals(""))
            {
                System.out.println("Input has in First Row");
            }
            else
            {
                System.out.println("row one has no prob");
                cCount1=1;
                this.cCount1=cCount1;
            }
            if((pageContext.getParameter("MCin2")!=null)&&pageContext.getParameter("MCin2").equals("")&&pageContext.getParameter("MCout2")!=null&&pageContext.getParameter("MCout2").equals(""))
            {
                 System.out.println("Input has in Second Row");
                
            }
            else
            {
                System.out.println("row two has no prob");
                cCount2=2;
                this.cCount2=cCount2;
            }
                if((pageContext.getParameter("MCin3")!=null)&&pageContext.getParameter("MCin3").equals("")&&pageContext.getParameter("MCout3")!=null&&pageContext.getParameter("MCout3").equals(""))
                {
                      System.out.println("Input has in Third Row");
                      
                }
            else
            {
                    System.out.println("row three has no prob");
                cCount3=3;
                this.cCount3=cCount3;
            }
                if((pageContext.getParameter("MCin4")!=null)&&pageContext.getParameter("MCin4").equals("")&&pageContext.getParameter("MCout4")!=null&&pageContext.getParameter("MCout4").equals(""))
                {
                      System.out.println("Input has in Fourth Row");
                }
            else
            {
                    System.out.println("row four Looks Fine");
                cCount4=4;
                this.cCount4=cCount4;
            }
            
      //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        
        /*Logic for inserting columns  into rows by set Attribute*/
        
        
            System.out.println("Values of VCount and cCount"+vCount+cCount);
            if(vCount==1&&cCount1==1)
            {
                System.out.println("Inside VCount 1 and cCount1 ");
                
                OAViewObject vo1=(OAViewObject)am.findViewObject("MoissPInfoVO1");         //Defining View Objects        
                Serializable[] sn={"MoissPInfoVO1"};                                       
                am.invokeMethod("createRecord", sn);                                     //Creating Row
                Number seqNum=txn.getSequenceValue("MOISS_PUNCH_INFO_ID_S");            //Obtaining Sequence for First row
             
                vo1.getCurrentRow().setAttribute("PunchInfoId", seqNum);
                vo1.getCurrentRow().setAttribute("PunchCode", "M1");
                vo1.getCurrentRow().setAttribute("EmployeeNumber", pageContext.getParameter("EmpNo"));
                vo1.getCurrentRow().setAttribute("EmployeeName", pageContext.getParameter("EmpName"));
                vo1.getCurrentRow().setAttribute("Department", pageContext.getParameter("Dept"));
                vo1.getCurrentRow().setAttribute("ManEntryYn", "Y");          
                vo1.getCurrentRow().setAttribute("State", "Cin");    
                String o=(cvo.getCurrentRow().getAttribute("Cin1")).toString();
                int oo=Integer.parseInt(o.substring(0,2));
                System.out.println(""+oo);
                if(oo > 12)
                {
                    t1=""+(oo-12)+o.substring(2)+" PM";
                    this.t1=t1;
                    System.out.println("The Value of T for Validation is "+t1);
                }
                else
                {
                    t1=""+(oo)+o.substring(2)+" AM";
                    this.t1=t1;
                    System.out.println("The Value of T for Validation is "+t1);
                
                }
                vo1.getCurrentRow().setAttribute("PunchDate", dtfor+" "+t1); 
                
                System.out.println("Value of 1 cin"+cvo.getCurrentRow().getAttribute("Cin1"));
                System.out.println("Value of 1 cin"+cvo.getCurrentRow().getAttribute("Cout1")); 
                
                OAViewObject vo2=(OAViewObject)am.findViewObject("MoissPInfoVO2"); 
                Serializable[] sn1={"MoissPInfoVO2"};
                am.invokeMethod("createRecord", sn1);                
                Number seqNum1=txn.getSequenceValue("MOISS_PUNCH_INFO_ID_S");           //Obtaining Sequence for Second row 
                
                vo2.getCurrentRow().setAttribute("PunchCode", "M1");
                vo2.getCurrentRow().setAttribute("PunchInfoId", seqNum1);
                vo2.getCurrentRow().setAttribute("EmployeeNumber", pageContext.getParameter("EmpNo"));
                vo2.getCurrentRow().setAttribute("EmployeeName", pageContext.getParameter("EmpName"));
                vo2.getCurrentRow().setAttribute("Department", pageContext.getParameter("Dept"));
                vo2.getCurrentRow().setAttribute("ManEntryYn", "Y");          
                vo2.getCurrentRow().setAttribute("State", "Cout");
                o=(cvo.getCurrentRow().getAttribute("Cout1")).toString();
                  oo=Integer.parseInt(o.substring(0,2));
                System.out.println(""+oo);
                if(oo > 11)
                {
                    t2=""+(oo-12)+o.substring(2)+" PM";
                    this.t2=t2;
                    System.out.println("The Value of T for Validation is "+t2);
                }
                else
                {
                    t2=""+(oo)+o.substring(2)+" AM";
                    this.t2=t2;
                    System.out.println("The Value of T for Validation is "+t2);
                
                }
                vo2.getCurrentRow().setAttribute("PunchDate", dtfor+" "+t2);
                
               
            }
        if(vCount==1&&cCount2==2)
        {
            System.out.println("Inside VCount 1 and cCount2 ");
            
            OAViewObject vo3=(OAViewObject)am.findViewObject("MoissPInfoVO3");
            Serializable[] sn={"MoissPInfoVO3"};
            am.invokeMethod("createRecord", sn);
            Number seqNum=txn.getSequenceValue("MOISS_PUNCH_INFO_ID_S");
           
            vo3.getCurrentRow().setAttribute("PunchInfoId", seqNum);
            vo3.getCurrentRow().setAttribute("PunchCode", "M1");
            vo3.getCurrentRow().setAttribute("EmployeeNumber", pageContext.getParameter("EmpNo"));
            vo3.getCurrentRow().setAttribute("EmployeeName", pageContext.getParameter("EmpName"));
            vo3.getCurrentRow().setAttribute("Department", pageContext.getParameter("Dept"));
            vo3.getCurrentRow().setAttribute("ManEntryYn", "Y");          
            vo3.getCurrentRow().setAttribute("State", "Cin");
            String o=(cvo.getCurrentRow().getAttribute("Cin2")).toString();
            int oo=Integer.parseInt(o.substring(0,2));
            System.out.println(""+oo);
            if(oo > 12)
            {
                t3=""+(oo-12)+o.substring(2)+" PM";
                this.t3=t3;
                System.out.println("The Value of T for Validation is "+t3);
            }
            else
            {
                t3=""+(oo)+o.substring(2)+" AM";
                this.t3=t3;
                System.out.println("The Value of T for Validation is "+t3);
            
            }
            vo3.getCurrentRow().setAttribute("PunchDate", dtfor+" "+t3); 
            //vo3.getCurrentRow().setAttribute("PunchDate", dtfor+" "+cvo.getCurrentRow().getAttribute("Cin2"));
        
            System.out.println("Value of 1 cin2"+cvo.getCurrentRow().getAttribute("Cin2"));
            System.out.println("Value of 1 cin2"+cvo.getCurrentRow().getAttribute("Cout2"));
            
            OAViewObject vo4=(OAViewObject)am.findViewObject("MoissPInfoVO4");
            Serializable[] sn1={"MoissPInfoVO4"};
            am.invokeMethod("createRecord", sn1);
            Number seqNum1=txn.getSequenceValue("MOISS_PUNCH_INFO_ID_S");
            
            vo4.getCurrentRow().setAttribute("PunchCode", "M1");
            vo4.getCurrentRow().setAttribute("PunchInfoId", seqNum1);
            vo4.getCurrentRow().setAttribute("EmployeeNumber", pageContext.getParameter("EmpNo"));
            vo4.getCurrentRow().setAttribute("EmployeeName", pageContext.getParameter("EmpName"));
            vo4.getCurrentRow().setAttribute("Department", pageContext.getParameter("Dept"));
            vo4.getCurrentRow().setAttribute("ManEntryYn", "Y");          
            vo4.getCurrentRow().setAttribute("State", "Cout");
            o=(cvo.getCurrentRow().getAttribute("Cout2")).toString();
            System.out.println("Value of O is for Cout 2"+o);
            oo=Integer.parseInt(o.substring(0,2));
            System.out.println("Value of oo is for Cout 2"+oo);
            System.out.println(""+oo);
            if(oo > 11)
            {
                t4=""+(oo-12)+o.substring(2)+" PM";
                this.t4=t4;
                System.out.println("The Value of T for Validation is "+t4);
            }
            else
            {
                t4=""+(oo)+o.substring(2)+" AM";
                this.t4=t4;
                System.out.println("The Value of T for Validation is "+t4);
            
            }
            vo4.getCurrentRow().setAttribute("PunchDate", dtfor+" "+t4);
            System.out.println("Testing for Field "+cvo.getCurrentRow().getAttribute("Cout2"));
            
        }
        if(vCount==1&&cCount3==3)
        {
            System.out.println("Inside VCount 1 and cCount3 ");
            
            OAViewObject vo5=(OAViewObject)am.findViewObject("MoissPInfoVO5");
            Serializable[] sn={"MoissPInfoVO5"};
            am.invokeMethod("createRecord", sn);
            Number seqNum=txn.getSequenceValue("MOISS_PUNCH_INFO_ID_S");
            
            vo5.getCurrentRow().setAttribute("PunchInfoId", seqNum);
            vo5.getCurrentRow().setAttribute("PunchCode", "M1");
            vo5.getCurrentRow().setAttribute("EmployeeNumber", pageContext.getParameter("EmpNo"));
            vo5.getCurrentRow().setAttribute("EmployeeName", pageContext.getParameter("EmpName"));
            vo5.getCurrentRow().setAttribute("Department", pageContext.getParameter("Dept"));
            vo5.getCurrentRow().setAttribute("ManEntryYn", "Y");          
            vo5.getCurrentRow().setAttribute("State", "Cin");
            String o=(cvo.getCurrentRow().getAttribute("Cin3")).toString();
            int oo=Integer.parseInt(o.substring(0,2));
            
            System.out.println("The Value of 3 oo and o is "+oo+"Na"+o);
            if(oo > 12)
            {
                t5=""+(oo-12)+o.substring(2)+" PM";
                this.t5=t5;
                System.out.println("The Value of T for Validation is "+t5);
            }
            else
            {
                t5=""+(oo)+o.substring(2)+" AM";
                this.t5=t5;
                System.out.println("The Value of T for Validation is "+t5);
            }
            vo5.getCurrentRow().setAttribute("PunchDate", dtfor+" "+t5);
                 
            System.out.println("Value of 1 cin 3"+cvo.getCurrentRow().getAttribute("Cin3"));
            System.out.println("Value of 1 cout 3"+cvo.getCurrentRow().getAttribute("Cout3"));
            
            OAViewObject vo6=(OAViewObject)am.findViewObject("MoissPInfoVO6");
            Serializable[] sn1={"MoissPInfoVO6"};
            am.invokeMethod("createRecord", sn1);
            Number seqNum1=txn.getSequenceValue("MOISS_PUNCH_INFO_ID_S");         
            
            vo6.getCurrentRow().setAttribute("PunchCode", "M1");
            vo6.getCurrentRow().setAttribute("PunchInfoId", seqNum1);
            vo6.getCurrentRow().setAttribute("EmployeeNumber", pageContext.getParameter("EmpNo"));
            vo6.getCurrentRow().setAttribute("EmployeeName", pageContext.getParameter("EmpName"));
            vo6.getCurrentRow().setAttribute("Department", pageContext.getParameter("Dept"));
            vo6.getCurrentRow().setAttribute("ManEntryYn", "Y");          
            vo6.getCurrentRow().setAttribute("State", "Cout");
            o=(cvo.getCurrentRow().getAttribute("Cout3")).toString();
              oo=Integer.parseInt(o.substring(0,2));
            System.out.println(""+oo);
            if(oo > 11)
            {
                t6=""+(oo-12)+o.substring(2)+" PM";
                this.t6=t6;
                System.out.println("The Value of T for Validation is "+t6);
            }
            else
            {
                t6=""+(oo)+o.substring(2)+" AM";
                this.t6=t6;
                System.out.println("The Value of T for Validation is "+t6);
            
            }
            vo6.getCurrentRow().setAttribute("PunchDate", dtfor+" "+t6);
            
            //vo6.getCurrentRow().setAttribute("PunchDate", dtfor+" "+cvo.getCurrentRow().getAttribute("Cout3"));
           
        }
        if(vCount==1&&cCount4==4)
        {
            System.out.println("Inside VCount 1 and cCount4 ");
            
            OAViewObject vo7=(OAViewObject)am.findViewObject("MoissPInfoVO7");
            Serializable[] sn={"MoissPInfoVO7"};
            am.invokeMethod("createRecord", sn);
            Number seqNum=txn.getSequenceValue("MOISS_PUNCH_INFO_ID_S");
      
            vo7.getCurrentRow().setAttribute("PunchInfoId", seqNum);
            vo7.getCurrentRow().setAttribute("PunchCode", "M1");
            vo7.getCurrentRow().setAttribute("EmployeeNumber", pageContext.getParameter("EmpNo"));
            vo7.getCurrentRow().setAttribute("EmployeeName", pageContext.getParameter("EmpName"));
            vo7.getCurrentRow().setAttribute("Department", pageContext.getParameter("Dept"));
            vo7.getCurrentRow().setAttribute("ManEntryYn", "Y");          
            vo7.getCurrentRow().setAttribute("State", "Cin");
            
            String o=(cvo.getCurrentRow().getAttribute("Cin4")).toString();
            int oo=Integer.parseInt(o.substring(0,2));
            System.out.println(""+oo);
            if(oo > 12)
            {
                t7=""+(oo-12)+o.substring(2)+" PM";
                this.t7=t7;
                System.out.println("The Value of T for Validation is "+t7);
            }
            else
            {
                t7=""+(oo)+o.substring(2)+" AM";
                this.t7=t7;
                System.out.println("The Value of T for Validation is "+t7);            
            }
            vo7.getCurrentRow().setAttribute("PunchDate", dtfor+" "+t7); 
              
            System.out.println("Value of 1 cin"+cvo.getCurrentRow().getAttribute("Cin1"));
            System.out.println("Value of 1 cin"+cvo.getCurrentRow().getAttribute("Cout1"));
            
            OAViewObject vo8=(OAViewObject)am.findViewObject("MoissPInfoVO8");
            Serializable[] sn1={"MoissPInfoVO8"};
            am.invokeMethod("createRecord", sn1);
            Number seqNum1=txn.getSequenceValue("MOISS_PUNCH_INFO_ID_S");
            
            vo8.getCurrentRow().setAttribute("PunchCode", "M1");
            vo8.getCurrentRow().setAttribute("PunchInfoId", seqNum1);
            vo8.getCurrentRow().setAttribute("EmployeeNumber", pageContext.getParameter("EmpNo"));
            vo8.getCurrentRow().setAttribute("EmployeeName", pageContext.getParameter("EmpName"));
            vo8.getCurrentRow().setAttribute("Department", pageContext.getParameter("Dept"));
            vo8.getCurrentRow().setAttribute("ManEntryYn", "Y");          
            vo8.getCurrentRow().setAttribute("State", "Cout");
            o=(cvo.getCurrentRow().getAttribute("Cout4")).toString();
            oo=Integer.parseInt(o.substring(0,2));
            System.out.println(""+oo);
            if(oo > 11)
            {
                t8=""+(oo-12)+o.substring(2)+" PM";
                this.t8=t8;
                System.out.println("The Value of T for Validation is "+t8);
            }
            else
            {
                t8=""+(oo)+o.substring(2)+" AM";
                this.t8=t8;
                System.out.println("The Value of T for Validation is "+t8);
            
            }
            vo8.getCurrentRow().setAttribute("PunchDate", dtfor+" "+t8); 
           
        }
        if((vCount==1&&cCount1==1)||(vCount==1&&cCount2==2)||(vCount==1&&cCount3==3)||(vCount==1&&cCount4==4))
        {
            System.out.println("Under Commit");
//            OAException confirmMessage = new OAException("Record Has Been Saved", OAException.CONFIRMATION);
//            pageContext.putDialogMessage(confirmMessage);
            am.invokeMethod("apply");       
            HashMap hm=new HashMap();  //Tried to send parameter through SetFowardURL
             hm.put("key", this.key);
             pageContext.forwardImmediatelyToCurrentPage(hm, false, "Y");
            OAException confirmMessage = new OAException("Record Has Been Saved", OAException.CONFIRMATION);
            pageContext.putDialogMessage(confirmMessage);
        }
        
        

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        
      }
 //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        /*Clear Button */
         if (pageContext.getParameter(EVENT_PARAM).equals("ClearButton"))
         {     
             HashMap hm=new HashMap();  //Tried to send parameter through SetFowardURL
             hm.put("key", this.key);
             hm.put("employeeNumber", pageContext.getParameter("employeeNumber"));
             hm.put("organizationId", pageContext.getParameter("organizationId"));
             hm.put("fromDate", pageContext.getParameter("fromDate"));
             hm.put("toDate", pageContext.getParameter("toDate"));
             hm.put("url", pageContext.getParameter("/moiss"));
               
              
              
             pageContext.forwardImmediatelyToCurrentPage(hm, false, "Y");
               
          }
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
       if (pageContext.getParameter(EVENT_PARAM).equals("ExitPG"))
       {     
       //     HashMap hm=new HashMap();  //Tried to send parameter through SetFowardURL
       //      hm.put("urlPG", this.keyparam);
             pageContext.forwardImmediatelyToCurrentPage(null, false, "Y");
             
            HashMap hm=new HashMap();  //Tried to send parameter through SetFowardURL
            hm.put("key", this.key); 
            hm.put("employeeNumber", pageContext.getParameter("employeeNumber"));
            hm.put("organizationId", pageContext.getParameter("organizationId"));
            hm.put("fromDate", pageContext.getParameter("fromDate"));
            hm.put("toDate", pageContext.getParameter("toDate"));
            hm.put("url", pageContext.getParameter("/moiss"));
            hm.put("fromManualEntry", pageContext.getParameter("Y"));
            
            // pageContext.
            pageContext.setForwardURL(tourl,
            null,
            //OAWebBeanConstants.KEEP_NO_DISPLAY_MENU_CONTEXT,
             OAWebBeanConstants.KEEP_NO_DISPLAY_MENU_CONTEXT,
            null,
            hm, 
            true,
            OAWebBeanConstants.ADD_BREAD_CRUMB_YES,
            OAWebBeanConstants.IGNORE_MESSAGES);
            
             
        }
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            
  }
       }
}
