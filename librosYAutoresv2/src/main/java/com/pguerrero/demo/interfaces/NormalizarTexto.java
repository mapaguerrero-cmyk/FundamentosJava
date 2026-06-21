package com.pguerrero.demo.interfaces;

import java.text.Normalizer;

public interface NormalizarTexto {
	// Metodo para normalizar con ReGex (Expresiones Regulares)
	default String normalizarTexto(String texto) {
		String normalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
		return normalizado.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "").toLowerCase();
	}

}
