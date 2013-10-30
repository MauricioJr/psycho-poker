package br.com.amil.business;

import java.io.IOException;
import java.util.List;

public interface FileReader {

	public List<String> getFileLine() throws IOException;
}
