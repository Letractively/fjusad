<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page import="javax.jdo.PersistenceManager" %>
<%@ page import="seminar.*" %>
<%@ page import="shared.PMF" %>
<%@ page import="javax.jdo.Query" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>clean datastore</title>
</head>
<body>
<%
PersistenceManager pm = PMF.get().getPersistenceManager();
try{
	//Seminar s = pm.getObjectById(Seminar.class, "Java 2");
	//s.removeAllRegistrations();

	Query query = pm.newQuery(Registration.class);
	List<Registration> results = (List<Registration>) query.execute();
	//for (Registration r:results){
		//pm.deletePersistent(r);
		//s.removeAllRegistrations();
		//s.removeRegistration(0);
	//}
	pm.deletePersistentAll(results);
} catch(javax.jdo.JDOUserException e){
	out.println(e);
}finally {
    pm.close();
}


%>
DONE
</body>
</html>