package com.demojanine.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.demojanine.dto.FilmeDTO;

public class sapiService {
	private static int HTTP_COD_SUCESSO = 200;

	public static void main(String[] args) throws JAXBException {

		try {

			URL url = new URL("http://swapi.dev/api/films/1/");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			if (con.getResponseCode() != HTTP_COD_SUCESSO) {
				throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));

			JAXBContext jaxbContext = JAXBContext.newInstance(FilmeDTO.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			FilmeDTO filme = (FilmeDTO) jaxbUnmarshaller.unmarshal(br);

			System.out.println("Nome da Banda : "+filme);

			//int count = 1;

			con.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
