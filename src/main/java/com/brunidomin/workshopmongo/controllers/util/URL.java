package com.brunidomin.workshopmongo.controllers.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

// Classe de decodificação de caracteres especiais nas URLs 
// Para uso dos Query Methods
public class URL {

	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			return "";
		}
	}
}
