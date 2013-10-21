package test.java;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.amil.business.FileReader;

public class TestFileReader {

	@Test
	public void getFileLineTest(){
		
		List<String> expectedResult = new ArrayList<String>();
		expectedResult.add("TH JH QC QD QS QH KH AH 2S 6S");
		expectedResult.add("2H 2S 3H 3S 3C 2D 3D 6C 9C TH");
		expectedResult.add("2H 2S 3H 3S 3C 2D 9C 3D 6C TH");
		expectedResult.add("2H AD 5H AC 7H AH 6H 9H 4H 3C");
		expectedResult.add("AC 2D 9C 3S KD 5S 4D KS AS 4C");
		expectedResult.add("KS AH 2H 3C 4H KC 2C TC 2D AS");
		expectedResult.add("AH 2C 9S AD 3C QH KS JS JD KD");
		expectedResult.add("6C 9C 8C 2D 7C 2H TC 4C 9S AH");
		expectedResult.add("3D 5S 2H QD TD 6S KH 9H AD QH");
		
		List<String> contentLines = null;
		  FileReader fr = new FileReader();
		
		try {
			contentLines = fr.getFileLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		assertEquals(expectedResult, contentLines);
	}
}
