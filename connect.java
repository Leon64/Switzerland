import java.net.*;
import java.io.*;

public class connect
{
    public static void main(String[] args) throws Exception
    {

	/*if (args.length == 0 || args.length > 1) 
	{
	    System.out.println("Type Ex: connect http://google.com");
	    return;
	}*/

	String realURL = "https://cas.rutgers.edu/login?service=https://my.rutgers.edu/portal/Login&renew=true";
	String user = "lwc28";
	String pass = "dummyPassword";
	String warn = "True";
	String authenticationType = "Kerberos";
	String lt = "_cNoOpConversation id_krO0ABXNyAGFvcmcuc3ByaW5nZnJhbWV3b3JrLndlYmZsb3cuZXhlY3V0aW9uLnJlcG9zaXRvcnkuY29udGludWF0aW9uLlNlcmlhbGl6ZWRGbG93RXhlY3V0aW9uQ29udGludWF0aW9uPMZQHZQEyycMAAB4cgBXb3JnLnNwcmluZ2ZyYW1ld29yay53ZWJmbG93LmV4ZWN1dGlvbi5yZXBvc2l0b3J5LmNvbnRpbnVhdGlvbi5GbG93RXhlY3V0aW9uQ29udGludWF0aW9ujvgpwtO1430CAAB4cHoAAAQAAAAK3B-LCAAAAAAAAAClWX1sFMcVH9sYsLHhDBhwCAklUL6aO0oNhJg4NWcbDh3g2gai0A_Gu-O7xXu7y-ycfU4LiaISVWooTQSpWqUhVZq0alFD-aONiFRKU9o_UlAblYpQRc0_rVRFqZRWVaVWafve7OzH3S2-QznJ4935-L0373Pm7fn3SbPLyXab55Kuww0rN85pgU3ZfCI5xcbGTXsqyaycYbGkUXDM5CB0DJSYVhSGbWWgZ9kDHe57r1w51UZIyRGk3bRh8v1qKSAvPkonaRKmm8msYU0wPWu4om39yOf2HPnKqiZcNDWLENIAU7fdCRMjzHUVC7lV59_Sv7DxumThGDlBGoGPSYNNZZGXQZsXaoL7O4pCjwgqiu7Y1c9M_eWldzc1Ajgnm-JQNJsz4K9YcJO4xtCydIyZTB-ArssX28_t6cm91UgasmSWZutMkI4syiRlUiuXGsnbXPQA8uYayH1jruBUExHsp_XRXZ_99oV_IWsObHGBFDXCJiVsfu-2Rd1Hbg0D7RHSPEnNIgNCiXDWvmJhjPGnzp9dMe_Mu1-VMKQJgB6aSVaSJ802TaZJiWVtjZp9QnBjrCjYXuqs680_lnjk2ONNuOVW6o-4gizwNo7GkIKJPZLrjtBAdlM3D_3Nc25deWPJkd81kcZB0mraVB-Ejds8Q1pEnjM3b5t6yXn40wR_bVNzoU3AX7Mgc1zGJw2NAewg7uEodY1cUqNukhZFnlmgGyqZxr1phkPN5AhaFDvExvocx1TDIx4K2pb7_dOnXyx8cEvqrw2IO7blstFpB_TYmwUaKUkjBTRS5TRSAY3UsFq2ejiyHpXeXyeTvvJj2exd-vLzb_8nfbaRzH6UJMD_ckzfXxR9JmdUn0YVcGGMw-qMLsjCqO0J1HAPzMgL4aRNA2gLcm_FrqS2dgcTYHqjoaOXdWXJPJsb4GLUPMBN1dUScC3I5noFNOQ_gUkQB8LIOuTIfTCV0qwkL4oc426S6cXUsPcsHTtJXaeEVFc4JzjZUacoY3VB1G-hdPL5oYegm0UHgbW5wwP9meGB9Kgg8zTOdKRCTRdMjgKHIbeWYBzIumxmfg6AyVrgY0PUdcHP9L6yichcOiTywvlU9_HBxTelNS6kVVOlDmAHO-sURiXxCKmnu19qXrnh1E8aSWOWzHXUBKXkuUW10CPoOKizDq3IOazGgLt_7CiEBxxdA24_RbmVtu0Jgx3EIBQ4vRTxTts2GbWureRP3Hj-33-DrT3qByuHCLIE2J5gYhenwJeVG5VvGd0plVyET8h2UVUwgBTQGxfFANjQPTHsNCx9oKQxR75VMQ9cfuJOEO6-dvOVS10XNkrdtI_BECwDIyua4HoAAAQAVEnpCRVQqRAqtTM6H0PDoogR-iR---G9vXf13P1LLxdFZozmuT1Fx0x241db1m6feu3NJtKUJc0aBT0J0hnx-WAm-HE7JCNqmHsh3dGcp8rDpNUVVJsYhWgDK-85XBYu_IEBkxUwFHjZttspcn-myj5VMxsHN-zY8eGq7V6OIWQHSHf5DAtoy9VvfXzrOycbyawMpADI_F6uypL5OtNMinJMm2CUvkGOGybb5xskRLQCE3lb3xeaKBwx2gVZX0Oj_VRQVAXjYLbhSxJZFaQlx8QA5zb36G4DMzshyP0zZUvqJUk0qz75CLjhi8Kdb1iGtLwK8DP48BA2vYIsZZZb5CycNlBybJfp_uyGP0dnt4Dii448-8jx_8FPkDVuEeIpG8fcndzFLMapYPpeKas-DfKma_Mtm8GXZxvWpD3BfGzSBSE5urYfziA5ig5ZvhhTpiAfm2lY7hlxB4N9HhBkWWgMPg1vKURZ76F6HdEE2TqT8OWhot9wHSq0vIeSkfsC7d4V2x9D5CR4bx0a3gt-a_gqTkTefNvRbe_cHAr154J8sg5kP_n74IvKOxT-HFaB_qyIP1NWHKj7LMsWaAU-_OKKnkAkhwLonhqM-9ByvbdrOI4C42UdMcDfrOFNZcB4kQBvCl9iAD8v4oN4BeBBuCzg0R1C3vzg2RcsKA5zeYB5GXyhDkyF1xrFamZlSL-vb7sQGC3XUMEjfInZ7lYRf0OpAOxnmuHfcIDFhWXvAawe7hgfxrHJYZMPN4APR7GZqGAEHwrYWB8VaqKGk1cJCbOb2tmymF5frWCIk6COIAgtEWRtHXTwggjejP8CSU0FzF4TpK_eW-wwOwZnIZEGtXLbxH-sJLwAes9txxT38-BoB8fush2Q79SIVGXeoySUiLzdgeYbW_BhGpvHwKzhzMBDPq7gw5ewOY7Nl4OBH4uPUGiAo2BVX8BxSON1QbbUvupD9AnB_LTVWdmlhD3bpEVLC031uCAP10XCLToOBD5JSml0N7V0E_PP0upORa4jL18j4wHll0U9dQygXJjUJFVlQJLiovIORa3To6YoZTA-gWFFI_LtvC-Jl22TCUnMz0lRgkurOxXR9jKiAbFNwru51CLm3dlDVCW_Pp06AgnfN_MEX60eEz71ponbZ7WAun9oYHzE6wGrrOpT-K267Q8FNNbiwwvYnJNHAnWFD9yq5_YBPOBh0O8NWOis7PLPlQ638eBVIeeGf-LDd7EBg2rW7V0sDIMGRB9cXQro4VU8iQWAgF4i8ha4YGcAcQ0ffoDND8sGGlYJksLdUYeCuOBqKuDkbVGvpBQpbAwaJqgpnacGZLzl8QNqiwlDWWy_7Q0GxnQdH36Ezatwadcrh3oAAALhwdY-hbwYluuwCcGBiUIBkipK2qt0ZKxxG65LjOqyxOWtF2TlDKM-Uz61KnfKKqpx-h33IPZbGhtiXOnMp9oV1x3I_mJA4L1w19hciBNH-Yq_qkNIrFIgL1g65fohTh2Hcbi-T0LS6Irrjjk6X64HWiW3Suhodwz044JsqAm923Z93CVVfTGg44JsjAOdxPluUl67hhmGdIXaWdkVA1pQR9AZOR2QmU-hLovprQZuWHMbbjXbshjWS5Npe9oWLAiLC8veqx2X_EyQ1RHEoxMyBsDUPRPe0iB7La7oiWHvPojD5WDKw9QSZcmQl8o7qqGa5gqyKhYKIgHs1RyxsSiEG4y-x1w05cnkBjZ_gDyromPakxeEl4Dgk8pNZya42vsXrlfAzbxoZcKIelGdehSYsAugKu9uKmQAcZNeIBmybXO1SlrDRUseWfHEHwyq8NIE-AH6cyJa0ffmwvnQewhE8KeSy8kDtcpZjFpD3AaHFtNl9ajvPXN2-dfWvfkbWdqaDWe9nJR2pDbklcywbrWjBhH_TBBLSGtd8etLgxu-6BW4uuuEKoMQV0_fXPvsOzcaySzglclKCYgo8uUBr4o9WbK44NW90rbOIEO6NngZWPaWWpW6vTHLsIZuSxFEalAJPP5xmM30QYOZesUHkBEm5RV7AYzZpFfzGX1m9osdf28_I6uyrRa4C9OHqMgrkgvCHllSC741eRSxqwdr2CT4WiTNUA4k_rvhF6-3PLXCk30iHD0og8nb3zh--ImeVxuaSFOGdGhozIaYzlgalwW7DGljXukubRctcZjMU69YRAMfPxxjLI5fWS9yf4JnxWrC168_ci7hrjf9omGrE_y84m-T_HRI0LYfrFXYY-MUrCNOee1P_PEfb5xKf-BZN2hs3JCfFbq88ub72Kyq_lAF-rvUf_Lsc6_9tNv7jNmGpWdViCYSASJ0TZ8rL0KH9Xdc310qOaVS6f8omnLPpB0AAAF4";


	String query = String.format("username=%s&password=%s&authenticationType=%s&warn=%s&lt=%s", URLEncoder.encode(user, "UTF-8"), URLEncoder.encode(pass, "UTF-8"), URLEncoder.encode(authenticationType, "UTF-8"), URLEncoder.encode(warn, "UTF-8"), URLEncoder.encode(lt, "UTF-8"));
        
	URL url = new URL(realURL);
	
	HttpURLConnection connect = (HttpURLConnection)url.openConnection();

	connect.setDoOutput(true);
	connect.setRequestMethod("POST");
	
	DataOutputStream uP = new DataOutputStream(connect.getOutputStream());
	
	uP.writeBytes(query);
	uP.flush();
	uP.close();

	//System.out.println(connect.getOutputStream());

	BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
	String line = "";

	while((line=in.readLine())!=null)
        {
	    System.out.println(line);
	}
	in.close();

	/*InputStream is = connect.getInputStream();
	BufferedReader rd = new BufferedReader(new InputStreamReader(is));
	String line;
	StringBuffer response = new StringBuffer();
	while((line = rd.readLine()) != null)
	{
	    response.append(line);
	    response.append('\r');
	}
	rd.close();
	response.toString();

	System.out.println(response);*/

	//System.out.println(connect.getResponseCode());

	if (realURL.equals(connect.getURL()))
	{
	    System.out.print("Success");
	    System.out.println(connect.getURL());
	    System.out.println(realURL);
	}
	else
	{
	    System.out.println("Failure");
	    System.out.println(connect.getURL());
	    System.out.println(realURL);
	}

    }
}