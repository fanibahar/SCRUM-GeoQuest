<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
</head>

<body>
<form id="form1" name="form1" method="post" action="">
  <p>Route Coordinates</p>
  <table width="200" border="0">
    <tr>
      <td colspan="4">Starting Point:</td>
    </tr>
    <tr>
      <td width="52">Latitude:</td>
      <td width="85"><label>
        <input name="lat1" type="text" id="lat1" size="15" maxlength="15" />
      </label></td>
      <td width="17">Longitude:</td>
      <td width="18"><input name="long1" type="text" id="long1" size="15" maxlength="15" /></td>
    </tr>
    <tr>
      <td colspan="4">&nbsp;</td>
    </tr>
    <tr>
      <td>Latitude:</td>
      <td><input name="lat2" type="text" id="lat2" size="15" maxlength="15" /></td>
      <td>Longitude:</td>
      <td><input name="long2" type="text" id="long2" size="15" maxlength="15" /></td>
    </tr>
    <tr>
      <td colspan="4">&nbsp;</td>
    </tr>
    <tr>
      <td>Latitude:</td>
      <td><input name="lat3" type="text" id="lat3" size="15" maxlength="15" /></td>
      <td>Longitude:</td>
      <td><input name="long3" type="text" id="long3" size="15" maxlength="15" /></td>
    </tr>
    <tr>
      <td colspan="4">&nbsp;</td>
    </tr>
    <tr>
      <td>Latitude:</td>
      <td><input name="lat4" type="text" id="lat4" size="15" maxlength="15" /></td>
      <td>Longitude:</td>
      <td><input name="long4" type="text" id="long4" size="15" maxlength="15" /></td>
    </tr>
    <tr>
      <td colspan="4">&nbsp;</td>
    </tr>
    <tr>
      <td>Latitude:</td>
      <td><input name="lat5" type="text" id="lat5" size="15" maxlength="15" /></td>
      <td>Longitude:</td>
      <td><input name="long5" type="text" id="long5" size="15" maxlength="15" /></td>
    </tr>
  </table>
  <p>
    <label>
    <input type="submit" name="sendRoutePoints" id="sendRoutePoints" value="Make Route!" />
    </label>
  </p>
</form>
<p>&nbsp;</p>
<p>&nbsp;</p>
</body>
</html>
