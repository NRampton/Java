import java.lang.Integer;
public class StringManipulator {
  String trimAndConcat(String str1, String str2) {
    return str1.trim() + str2.trim();
  }

  Integer getIndexOrNull(String str, char a) {
    if (str.indexOf(a) != -1) {
      return str.indexOf(a);
    } else {
      return null;
    }
  }

  Integer getIndexOrNull(String str, String subStr) {
    if (str.indexOf(subStr) != -1) {
      return str.indexOf(subStr);
    } else {
      return null;
    }
  }

  String concatSubString( String str1, int start, int end, String str2) {
    return str1.substring(start, end) + str2;
  }
}