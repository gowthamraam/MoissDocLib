/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package moiss.oracle.apps.fnd.moiss.webui;

import com.sun.ejb.ejbql.parser.ParseException;
import com.sun.java.util.collections.HashMap;

import java.io.Serializable;

import java.sql.Date;

import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.util.Calendar;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.OAViewObject;
import oracle.apps.fnd.framework.server.OADBTransaction;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageDateFieldBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageStyledTextBean;

import oracle.apps.fnd.framework.webui.beans.message.OAMessageTextInputBean;

import oracle.jbo.domain.Number;

/**
 * Controller for ...
 */
public class ManEntCO extends OAControllerImpl
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
//    super.processRequest(pageContext, webBean);
//      OAApplicationModule am=(OAApplicationModule)pageContext.getApplicationModule(webBean);
//      Serializable[] sn={"MoissCIOVO"};
//       am.invokeMethod("createRecord", sn);
//     
//      OAMessageStyledTextBean st3=(OAMessageStyledTextBean)webBean.findChildRecursive("item63");
//      OAMessageStyledTextBean st4=(OAMessageStyledTextBean)webBean.findChildRecursive("item621");
//      
//      
//      OAMessageStyledTextBean st5=(OAMessageStyledTextBean)webBean.findChildRecursive("item622");
//      OAMessageStyledTextBean st6=(OAMessageStyledTextBean)webBean.findChildRecursive("item623");
//      
//      
//      OAMessageStyledTextBean st7=(OAMessageStyledTextBean)webBean.findChildRecursive("item632");
//      OAMessageStyledTextBean st8=(OAMessageStyledTextBean)webBean.findChildRecursive("item6212");
//      
//      
//      OAMessageStyledTextBean st9=(OAMessageStyledTextBean)webBean.findChildRecursive("item631");
//      OAMessageStyledTextBean st10=(OAMessageStyledTextBean)webBean.findChildRecursive("item6211");
//        
//      st3.setValue(pageContext, "In1");
//      st4.setValue(pageContext, "Out1");
//      st5.setValue(pageContext, "In2");
//      st6.setValue(pageContext, "Out2");
//      st7.setValue(pageContext, "In4");
//      st8.setValue(pageContext, "Out4");
//      st9.setValue(pageContext, "In3");
//      st10.setValue(pageContext, "Out3");
//      OAViewObject cvo1=(OAViewObject)am.findViewObject("MoissCIOVO");
//      cvo1.getCurrentRow().setAttribute("RowNumber", "1");
//
//      System.out.println("cvo1.getCurrentRow().getAttribute(\"RowNumber\")"+cvo1.getCurrentRow().getAttribute("RowNumber"));

  }

  /**
   * Procedure to handle form submissions for form elements in
   * a region.
   * @param pageContext the current OA page context
   * @param webBean the web bean corresponding to the region
   * Here in this project the UI has eight columns and the data gets stored in 8 rows
   */
//   int vCount=0;
//   int cCount=0;
//    int cCount1=0;
//    int cCount2=0;
//    int cCount3=0;
//    int cCount4=0;
//    String dtfor=null;
//    String t1;
//    String t2;
//    String t3;
//    String t4;
//    String t5;
//    String t6;
//    String t7;
//    String t8;
//    String t9;
//    
  public void processFormRequest(OAPageContext pageContext, OAWebBean webBean)
  {
    super.processFormRequest(pageContext, webBean);
//      OAApplicationModule am=(OAApplicationModule)pageContext.getApplicationModule(webBean);                //Getting AM Object
//      OAViewObject cvo=(OAViewObject)am.findViewObject("MoissCIOVO");                                       //Obtaining Transient VO for saving in Eight rows
//       OADBTransaction txn =(OADBTransaction)am.getOADBTransaction();
//          
//    if(pageContext.getParameter(EVENT_PARAM).equals("updatefordate"))                                                //Logic for Commit / Save
//    {
//    
//        System.out.println("Insidte date--------------------------------------------------------------------->");
//        String dt=(cvo.getCurrentRow().getAttribute("Date")).toString() ;
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
//        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy"); 
//         
//        try{
//        java.util.Date aj =(sdf.parse(dt));
//        this.dtfor=sdf1.format(aj);
//        
//        }
//        catch(Exception e)
//        {
//                System.out.println("Exception Occured"+e);
//        }
//        
//        System.out.println("First test for dtfor"+dt+dtfor);
//        this.dtfor=dtfor;
//        
////        OAMessageDateFieldBean ti=(OAMessageDateFieldBean)webBean.findChildRecursive("DateFieldItem");
////         String dt=(ti.getValue(pageContext)).toString();        try{
////        this.dtfor=(sdf.parse(dt)).toString();
////        }
////        catch(Exception e)
////        {
////                System.out.println("Exception Occured"+e);
////        }
////        System.out.println("Second test for dtfor"+dt+dtfor);
////        this.dtfor=dtfor;
////    
//    }
//    if(pageContext.getParameter(EVENT_PARAM).equals("Save"))                                                //Logic for Commit / Save
//    {
//            System.out.println("Event Fired for save");
//        
//        
//        
//        System.out.println("Insidte date--------------------------------------------------------------------->");
// //          String dt=(cvo.getCurrentRow().getAttribute("Date")).toString() ;
//      ///      SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); 
////            
// System.out.println("Insidte date--------------------------------------------------------------------->");
//     String dt=(cvo.getCurrentRow().getAttribute("Date")).toString() ;
//     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
//     SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy"); 
// //
//     try{
//     java.util.Date aj =(sdf.parse(dt));
//     this.dtfor=sdf1.format(aj);
//     
//     }
//     catch(Exception e)
//     {
//             System.out.println("Exception Occured"+e);
//     }
//     
//     System.out.println("First test for dtfor"+dt+dtfor);
//     this.dtfor=dtfor;
////            OAMessageDateFieldBean ti=(OAMessageDateFieldBean)webBean.findChildRecursive("DateFieldItem");
////             String dt=(ti.getValue(pageContext)).toString(); 
////        DateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
////  
////String currdate1=dt;
////
////
////     
////             
////             try{
////            this.dtfor=(sdf.parse(dt)).toString();
////             java.util.Date   cdate = (java.util.Date)formatter1.parse(currdate1);   //Gets converted
////             System.out.println("ouptu asdfjklahsdfjkha---------------------------------->"+cdate);
////            }
////            catch(Exception e)
////            {
////                    System.out.println("Exception Occured"+e);
////            }
////            System.out.println("Second test for dtfor"+dt+dtfor);
////            this.dtfor=dtfor;
////        
//       
//        //dateCal.add(Calendar.DAY_OF_MONTH,31);
//
//        //dt = dateCal.getTime();
//
//        //  writeLog(XXPO_APP_SHORT_NAME,pageContext,”End date “+dt);  //To have a log(History)
//
//        //actionDateText.setMaxValue(dt);
//            
//            //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//            /*Logic for checking the columns as not null*/
//            if((pageContext.getParameter("EmpNo")!=null)&&(pageContext.getParameter("EmpNo").equals(""))&&(pageContext.getParameter("EmpName")!=null)&&(pageContext.getParameter("EmpName").equals(""))&&(pageContext.getParameter("Dept")!=null)&&(pageContext.getParameter("Dept").equals(""))&&(pageContext.getParameter("Date")!=null)&&(pageContext.getParameter("Date").equals("")))
//            {
//                   System.out.println("Invalid");
//            }
//            else
//            {
//                    System.out.println("Valid");
//                vCount=vCount+1;
//                this.vCount=vCount;
//            }
////---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//                /* Logic for automating the Punch Entry and it is currently under development*/
////            for(int j=0;j>=4;j++)
////            {
////                String k= "(pageContext.getParameter(\"MCin"+j+"\")!=null)&&pageContext.getParameter(\"MCin"+j+"\").equals(\"\")&&pageContext.getParameter(\"MCout"+j+"\")!=null&&pageContext.getParameter(\"MCout"+j+"1\").equals(\"\")";
////            }
////---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//                /*Logic For checking the In or out Is not at right range*/
//            if((pageContext.getParameter("MCin1")!=null)&&pageContext.getParameter("MCin1").equals("")&&pageContext.getParameter("MCout1")!=null&&pageContext.getParameter("MCout1").equals(""))
//            {
//                System.out.println("Input has in First Row");
//            }
//            else
//            {
//                System.out.println("row one has no prob");
//                cCount1=1;
//                this.cCount1=cCount1;
//            }
//            if((pageContext.getParameter("MCin2")!=null)&&pageContext.getParameter("MCin2").equals("")&&pageContext.getParameter("MCout2")!=null&&pageContext.getParameter("MCout2").equals(""))
//            {
//                 System.out.println("Input has in Second Row");
//                
//            }
//            else
//            {
//                System.out.println("row two has no prob");
//                cCount2=2;
//                this.cCount2=cCount2;
//            }
//                if((pageContext.getParameter("MCin3")!=null)&&pageContext.getParameter("MCin3").equals("")&&pageContext.getParameter("MCout3")!=null&&pageContext.getParameter("MCout3").equals(""))
//                {
//                      System.out.println("Input has in Third Row");
//                      
//                }
//            else
//            {
//                    System.out.println("row three has no prob");
//                cCount3=3;
//                this.cCount3=cCount3;
//            }
//                if((pageContext.getParameter("MCin4")!=null)&&pageContext.getParameter("MCin4").equals("")&&pageContext.getParameter("MCout4")!=null&&pageContext.getParameter("MCout4").equals(""))
//                {
//                      System.out.println("Input has in Fourth Row");
//                }
//            else
//            {
//                    System.out.println("row four Looks Fine");
//                cCount4=4;
//                this.cCount4=cCount4;
//            }
//            
////---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//        
//        /*Logic for inserting columns  into rows by set Attribute*/
//        
//        
//            System.out.println("Values of VCount and cCount"+vCount+cCount);
//            if(vCount==1&&cCount1==1)
//            {
//                System.out.println("Inside VCount 1 and cCount1 ");
//                
//                OAViewObject vo1=(OAViewObject)am.findViewObject("MoissPInfoVO1");         //Defining View Objects        
//                Serializable[] sn={"MoissPInfoVO1"};                                       
//                am.invokeMethod("createRecord", sn);                                     //Creating Row
//                Number seqNum=txn.getSequenceValue("MOISS_PUNCH_INFO_ID_S");            //Obtaining Sequence for First row
//             
//                vo1.getCurrentRow().setAttribute("PunchInfoId", seqNum);
//                vo1.getCurrentRow().setAttribute("PunchCode", "M1");
//                vo1.getCurrentRow().setAttribute("EmployeeNumber", pageContext.getParameter("EmpNo"));
//                vo1.getCurrentRow().setAttribute("EmployeeName", pageContext.getParameter("EmpName"));
//                vo1.getCurrentRow().setAttribute("Department", pageContext.getParameter("Dept"));
//                vo1.getCurrentRow().setAttribute("ManEntryYn", "Y");          
//                vo1.getCurrentRow().setAttribute("State", "Cin");    
//                String o=(cvo.getCurrentRow().getAttribute("Cin1")).toString();
//                int oo=Integer.parseInt(o.substring(0,2));
//                System.out.println(""+oo);
//                if(oo > 12)
//                {
//                    t1=""+(oo-12)+o.substring(2)+" PM";
//                    this.t1=t1;
//                    System.out.println("The Value of T for Validation is "+t1);
//                }
//                else
//                {
//                    t1=""+(oo)+o.substring(2)+" AM";
//                    this.t1=t1;
//                    System.out.println("The Value of T for Validation is "+t1);
//                
//                }
//                vo1.getCurrentRow().setAttribute("PunchDate", dtfor+" "+t1); 
//                
//                System.out.println("Value of 1 cin"+cvo.getCurrentRow().getAttribute("Cin1"));
//                System.out.println("Value of 1 cin"+cvo.getCurrentRow().getAttribute("Cout1")); 
//                
//                OAViewObject vo2=(OAViewObject)am.findViewObject("MoissPInfoVO2"); 
//                Serializable[] sn1={"MoissPInfoVO2"};
//                am.invokeMethod("createRecord", sn1);                
//                Number seqNum1=txn.getSequenceValue("MOISS_PUNCH_INFO_ID_S");           //Obtaining Sequence for Second row 
//                
//                vo2.getCurrentRow().setAttribute("PunchCode", "M1");
//                vo2.getCurrentRow().setAttribute("PunchInfoId", seqNum1);
//                vo2.getCurrentRow().setAttribute("EmployeeNumber", pageContext.getParameter("EmpNo"));
//                vo2.getCurrentRow().setAttribute("EmployeeName", pageContext.getParameter("EmpName"));
//                vo2.getCurrentRow().setAttribute("Department", pageContext.getParameter("Dept"));
//                vo2.getCurrentRow().setAttribute("ManEntryYn", "Y");          
//                vo2.getCurrentRow().setAttribute("State", "Cout");
//                o=(cvo.getCurrentRow().getAttribute("Cout1")).toString();
//                  oo=Integer.parseInt(o.substring(0,2));
//                System.out.println(""+oo);
//                if(oo > 11)
//                {
//                    t2=""+(oo-12)+o.substring(2)+" PM";
//                    this.t2=t2;
//                    System.out.println("The Value of T for Validation is "+t2);
//                }
//                else
//                {
//                    t2=""+(oo)+o.substring(2)+" AM";
//                    this.t2=t2;
//                    System.out.println("The Value of T for Validation is "+t2);
//                
//                }
//                vo2.getCurrentRow().setAttribute("PunchDate", dtfor+" "+t2);
//                
//               
//            }
//        if(vCount==1&&cCount2==2)
//        {
//            System.out.println("Inside VCount 1 and cCount2 ");
//            
//            OAViewObject vo3=(OAViewObject)am.findViewObject("MoissPInfoVO3");
//            Serializable[] sn={"MoissPInfoVO3"};
//            am.invokeMethod("createRecord", sn);
//            Number seqNum=txn.getSequenceValue("MOISS_PUNCH_INFO_ID_S");
//           
//            vo3.getCurrentRow().setAttribute("PunchInfoId", seqNum);
//            vo3.getCurrentRow().setAttribute("PunchCode", "M1");
//            vo3.getCurrentRow().setAttribute("EmployeeNumber", pageContext.getParameter("EmpNo"));
//            vo3.getCurrentRow().setAttribute("EmployeeName", pageContext.getParameter("EmpName"));
//            vo3.getCurrentRow().setAttribute("Department", pageContext.getParameter("Dept"));
//            vo3.getCurrentRow().setAttribute("ManEntryYn", "Y");          
//            vo3.getCurrentRow().setAttribute("State", "Cin");
//            String o=(cvo.getCurrentRow().getAttribute("Cin2")).toString();
//            int oo=Integer.parseInt(o.substring(0,2));
//            System.out.println(""+oo);
//            if(oo > 12)
//            {
//                t3=""+(oo-12)+o.substring(2)+" PM";
//                this.t3=t3;
//                System.out.println("The Value of T for Validation is "+t3);
//            }
//            else
//            {
//                t3=""+(oo)+o.substring(2)+" AM";
//                this.t3=t3;
//                System.out.println("The Value of T for Validation is "+t3);
//            
//            }
//            vo3.getCurrentRow().setAttribute("PunchDate", dtfor+" "+t3); 
//            //vo3.getCurrentRow().setAttribute("PunchDate", dtfor+" "+cvo.getCurrentRow().getAttribute("Cin2"));
//        
//            System.out.println("Value of 1 cin2"+cvo.getCurrentRow().getAttribute("Cin2"));
//            System.out.println("Value of 1 cin2"+cvo.getCurrentRow().getAttribute("Cout2"));
//            
//            OAViewObject vo4=(OAViewObject)am.findViewObject("MoissPInfoVO4");
//            Serializable[] sn1={"MoissPInfoVO4"};
//            am.invokeMethod("createRecord", sn1);
//            Number seqNum1=txn.getSequenceValue("MOISS_PUNCH_INFO_ID_S");
//            
//            vo4.getCurrentRow().setAttribute("PunchCode", "M1");
//            vo4.getCurrentRow().setAttribute("PunchInfoId", seqNum1);
//            vo4.getCurrentRow().setAttribute("EmployeeNumber", pageContext.getParameter("EmpNo"));
//            vo4.getCurrentRow().setAttribute("EmployeeName", pageContext.getParameter("EmpName"));
//            vo4.getCurrentRow().setAttribute("Department", pageContext.getParameter("Dept"));
//            vo4.getCurrentRow().setAttribute("ManEntryYn", "Y");          
//            vo4.getCurrentRow().setAttribute("State", "Cout");
//            o=(cvo.getCurrentRow().getAttribute("Cout2")).toString();
//            System.out.println("Value of O is for Cout 2"+o);
//              oo=Integer.parseInt(o.substring(0,2));
//            System.out.println("Value of oo is for Cout 2"+oo);
//            System.out.println(""+oo);
//            if(oo > 11)
//            {
//                t4=""+(oo-12)+o.substring(2)+" PM";
//                this.t4=t4;
//                System.out.println("The Value of T for Validation is "+t4);
//            }
//            else
//            {
//                t4=""+(oo)+o.substring(2)+" AM";
//                this.t4=t4;
//                System.out.println("The Value of T for Validation is "+t4);
//            
//            }
//            vo4.getCurrentRow().setAttribute("PunchDate", dtfor+" "+t4);
//          //  vo4.getCurrentRow().setAttribute("PunchDate", dtfor+" "+cvo.getCurrentRow().getAttribute("Cout2"));
//            System.out.println("Testing for Field "+cvo.getCurrentRow().getAttribute("Cout2"));
//            
//        }
//        if(vCount==1&&cCount3==3)
//        {
//            System.out.println("Inside VCount 1 and cCount3 ");
//            
//            OAViewObject vo5=(OAViewObject)am.findViewObject("MoissPInfoVO5");
//            Serializable[] sn={"MoissPInfoVO5"};
//            am.invokeMethod("createRecord", sn);
//            Number seqNum=txn.getSequenceValue("MOISS_PUNCH_INFO_ID_S");
//            
//            vo5.getCurrentRow().setAttribute("PunchInfoId", seqNum);
//            vo5.getCurrentRow().setAttribute("PunchCode", "M1");
//            vo5.getCurrentRow().setAttribute("EmployeeNumber", pageContext.getParameter("EmpNo"));
//            vo5.getCurrentRow().setAttribute("EmployeeName", pageContext.getParameter("EmpName"));
//            vo5.getCurrentRow().setAttribute("Department", pageContext.getParameter("Dept"));
//            vo5.getCurrentRow().setAttribute("ManEntryYn", "Y");          
//            vo5.getCurrentRow().setAttribute("State", "Cin");
//            String o=(cvo.getCurrentRow().getAttribute("Cin3")).toString();
//            int oo=Integer.parseInt(o.substring(0,2));
//            
//            System.out.println("The Value of 3 oo and o is "+oo+"Na"+o);
//            if(oo > 12)
//            {
//                t5=""+(oo-12)+o.substring(2)+" PM";
//                this.t5=t5;
//                System.out.println("The Value of T for Validation is "+t5);
//            }
//            else
//            {
//                t5=""+(oo)+o.substring(2)+" AM";
//                this.t5=t5;
//                System.out.println("The Value of T for Validation is "+t5);
//            }
//            vo5.getCurrentRow().setAttribute("PunchDate", dtfor+" "+t5);
//            
//            
//       //     vo5.getCurrentRow().setAttribute("PunchDate", dtfor+" "+cvo.getCurrentRow().getAttribute("Cin3"));
//            
//            System.out.println("Value of 1 cin 3"+cvo.getCurrentRow().getAttribute("Cin3"));
//            System.out.println("Value of 1 cout 3"+cvo.getCurrentRow().getAttribute("Cout3"));
//            
//            OAViewObject vo6=(OAViewObject)am.findViewObject("MoissPInfoVO6");
//            Serializable[] sn1={"MoissPInfoVO6"};
//            am.invokeMethod("createRecord", sn1);
//            Number seqNum1=txn.getSequenceValue("MOISS_PUNCH_INFO_ID_S");         
//            
//            vo6.getCurrentRow().setAttribute("PunchCode", "M1");
//            vo6.getCurrentRow().setAttribute("PunchInfoId", seqNum1);
//            vo6.getCurrentRow().setAttribute("EmployeeNumber", pageContext.getParameter("EmpNo"));
//            vo6.getCurrentRow().setAttribute("EmployeeName", pageContext.getParameter("EmpName"));
//            vo6.getCurrentRow().setAttribute("Department", pageContext.getParameter("Dept"));
//            vo6.getCurrentRow().setAttribute("ManEntryYn", "Y");          
//            vo6.getCurrentRow().setAttribute("State", "Cout");
//            o=(cvo.getCurrentRow().getAttribute("Cout3")).toString();
//              oo=Integer.parseInt(o.substring(0,2));
//            System.out.println(""+oo);
//            if(oo > 11)
//            {
//                t6=""+(oo-12)+o.substring(2)+" PM";
//                this.t6=t6;
//                System.out.println("The Value of T for Validation is "+t6);
//            }
//            else
//            {
//                t6=""+(oo)+o.substring(2)+" AM";
//                this.t6=t6;
//                System.out.println("The Value of T for Validation is "+t6);
//            
//            }
//            vo6.getCurrentRow().setAttribute("PunchDate", dtfor+" "+t6);
//            
//            //vo6.getCurrentRow().setAttribute("PunchDate", dtfor+" "+cvo.getCurrentRow().getAttribute("Cout3"));
//           
//        }
//        if(vCount==1&&cCount4==4)
//        {
//            System.out.println("Inside VCount 1 and cCount4 ");
//            
//            OAViewObject vo7=(OAViewObject)am.findViewObject("MoissPInfoVO7");
//            Serializable[] sn={"MoissPInfoVO7"};
//            am.invokeMethod("createRecord", sn);
//            Number seqNum=txn.getSequenceValue("MOISS_PUNCH_INFO_ID_S");
//    
//            vo7.getCurrentRow().setAttribute("PunchInfoId", seqNum);
//            vo7.getCurrentRow().setAttribute("PunchCode", "M1");
//            vo7.getCurrentRow().setAttribute("EmployeeNumber", pageContext.getParameter("EmpNo"));
//            vo7.getCurrentRow().setAttribute("EmployeeName", pageContext.getParameter("EmpName"));
//            vo7.getCurrentRow().setAttribute("Department", pageContext.getParameter("Dept"));
//            vo7.getCurrentRow().setAttribute("ManEntryYn", "Y");          
//            vo7.getCurrentRow().setAttribute("State", "Cin");
//            
//            String o=(cvo.getCurrentRow().getAttribute("Cin4")).toString();
//            int oo=Integer.parseInt(o.substring(0,2));
//            System.out.println(""+oo);
//            if(oo > 12)
//            {
//                t7=""+(oo-12)+o.substring(2)+" PM";
//                this.t7=t7;
//                System.out.println("The Value of T for Validation is "+t7);
//            }
//            else
//            {
//                t7=""+(oo)+o.substring(2)+" AM";
//                this.t7=t7;
//                System.out.println("The Value of T for Validation is "+t7);
//            
//            }
//            vo7.getCurrentRow().setAttribute("PunchDate", dtfor+" "+t7); 
//            
//           // vo7.getCurrentRow().setAttribute("PunchDate", dtfor+" "+cvo.getCurrentRow().getAttribute("Cin4"));
//            
//            System.out.println("Value of 1 cin"+cvo.getCurrentRow().getAttribute("Cin1"));
//            System.out.println("Value of 1 cin"+cvo.getCurrentRow().getAttribute("Cout1"));
//            
//            OAViewObject vo8=(OAViewObject)am.findViewObject("MoissPInfoVO8");
//            Serializable[] sn1={"MoissPInfoVO8"};
//            am.invokeMethod("createRecord", sn1);
//            Number seqNum1=txn.getSequenceValue("MOISS_PUNCH_INFO_ID_S");
//            
//            vo8.getCurrentRow().setAttribute("PunchCode", "M1");
//            vo8.getCurrentRow().setAttribute("PunchInfoId", seqNum1);
//            vo8.getCurrentRow().setAttribute("EmployeeNumber", pageContext.getParameter("EmpNo"));
//            vo8.getCurrentRow().setAttribute("EmployeeName", pageContext.getParameter("EmpName"));
//            vo8.getCurrentRow().setAttribute("Department", pageContext.getParameter("Dept"));
//            vo8.getCurrentRow().setAttribute("ManEntryYn", "Y");          
//            vo8.getCurrentRow().setAttribute("State", "Cout");
//            o=(cvo.getCurrentRow().getAttribute("Cout4")).toString();
//              oo=Integer.parseInt(o.substring(0,2));
//            System.out.println(""+oo);
//            if(oo > 11)
//            {
//                t8=""+(oo-12)+o.substring(2)+" PM";
//                this.t8=t8;
//                System.out.println("The Value of T for Validation is "+t8);
//            }
//            else
//            {
//                t8=""+(oo)+o.substring(2)+" AM";
//                this.t8=t8;
//                System.out.println("The Value of T for Validation is "+t8);
//            
//            }
//            vo8.getCurrentRow().setAttribute("PunchDate", dtfor+" "+t8);
//          //  vo8.getCurrentRow().setAttribute("PunchDate", dtfor+" "+cvo.getCurrentRow().getAttribute("Cout4"));
//            
//           
//        }
//        if((vCount==1&&cCount1==1)||(vCount==1&&cCount2==2)||(vCount==1&&cCount3==3)||(vCount==1&&cCount4==4))
//        {
//            System.out.println("Under Commit");
//            OAException confirmMessage = new OAException("Record Has Been Saved", OAException.CONFIRMATION);
//            pageContext.putDialogMessage(confirmMessage);
//            am.invokeMethod("apply");
//        }
//        
//        
//
////---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//        
//    }
////---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//        /*Clear Button */
//         if (pageContext.getParameter(EVENT_PARAM).equals("ClearButton"))
//         {     
//        //     HashMap hm=new HashMap();  //Tried to send parameter through SetFowardURL
//        //      hm.put("keyparam", this.keyparam);
//               pageContext.forwardImmediatelyToCurrentPage(null, false, "Y");
//               
//          }
////---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    }
}
