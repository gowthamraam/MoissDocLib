/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package moiss.oracle.apps.fnd.moiss.webui;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAApplicationModule;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.OAViewObject;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;

/**
 * Controller for ...
 */
public class DocLibUpdCO extends OAControllerImpl
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
    String docId = pageContext.getParameter("DocId");
    System.out.println("Doc Id value is sfjsdnfj"+docId);
      OAApplicationModule am=(OAApplicationModule)pageContext.getApplicationModule(webBean);
    OAViewObject vo=(OAViewObject)am.findViewObject("DocLibVO");
    String l="Doc_id like '%"+docId+"%' ";
 //   vo.setWhereClause(0, l);
 System.out.println("Valu ashdfalsfasldfjlasuifhuils"+l);
    vo.setWhereClause(l);
    vo.executeQuery();
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
    
      if(pageContext.getParameter(EVENT_PARAM).equals("Save"))
      {
          OAApplicationModule am=(OAApplicationModule)pageContext.getApplicationModule(webBean); 
          am.invokeMethod("apply");
          OAException confirmMessage = new OAException("Record Has Been Saved", OAException.CONFIRMATION);
          pageContext.putDialogMessage(confirmMessage);
    
      }
      if (pageContext.getParameter("ClearButton") != null)
      {     
   
      pageContext.forwardImmediatelyToCurrentPage(null,false,null);
      }
  }

}
