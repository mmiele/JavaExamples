package com.acloudysky.essentials;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;


/**
 * Demonstrates how byte, character and buffered streams work.
 * The following are the examples shown: </br>
 * <p>
 * 	<ol>
 * 		<li><b>Byte Streams</b>. The example uses the FileInputStream and FileOutputStream. <br/>
 * 				Other kinds of byte streams are used in much the same way; they differ mainly 
 * 			 	in the way they are constructed.</li>
 * 		<li><b>Character Streams</b>. The example uses the FileReader and FileWriter. <br/>
 * 				Other kinds of character streams are used in much the same way; they differ mainly 
 * 				in the way they are constructed. The character streams use the byte streams 
 * 				to perform the physical I/O then they handle the translation between characters and bytes. 
 * 				For example, FileReader uses FileInputStream, while FileWriter uses FileOutputStream.</li>
 * 		<li><b>Buffered Streams</b>. FileReader and FileWriter handle one character at the time. To handle a 
 * 				line this you buffer both FileReader and FileWriter  using BufferedReader and 
 * 				PrintWriter respectively. </li>
 * 	</ol>
 * </p>
 * @see FileInputStream FileOutputStream FileReader FileWriter BufferedReader PrintWriter
 * @author Michael
 */
public class Stream {

	/*
	 * Gets the absolute path of the files used in the I/O stream examples.
	 * The file is contained in the resources folder.
	 * @param fileName - the name of the file for which to get the absolute path.
	 * @return - the absolute path of the file.
	 */
	private String getFilePath (String fileName) {
		
		// Get the resource URL.
        URL resource = Stream.class.getResource("/" + fileName);
		URI uri = null;
		String filePath = null;
		try {
			// Get the resources URI.
			uri = resource.toURI();
			// Get the file.
			File currentFile = Paths.get(uri).toFile();
			// Get the file path and add the prefix file for the
			// expected format.
			filePath = currentFile.getPath();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
		// Return the file path.
		return filePath;

	}
	
	/**
	 * Copies input file content to the output file, one byte at the time. 
	 * <p>
	 * 	The method uses the following byte stream classes:
	 * 	<ol>
	 * 		<li>FileInputStream</li>
	 * 		<li>FileOutputStream</li>
	 * 	</ol> 
	 * </p>
	 * @param inFileName - The input file name.
	 * @param outFileName - The output file name.
	 * @throws IOException
	 */
    public void copyByteStream (String inFileName, String outFileName) throws IOException {

    	/* Input file byte stream */
        FileInputStream in = null;
        
    	/* Output file byte stream */
        FileOutputStream out = null;
        
        String inFilePath = this.getFilePath(inFileName);
        String outFilePath = this.getFilePath(outFileName);
        
        try {
        		/* Instantiate the input file byte stream. */
            	in = new FileInputStream(inFilePath);
            	
            	/* Instantiate the output file byte stream. */
            	out = new FileOutputStream(outFilePath);
            	int c;
            	
            	/* Read from  the input file stream and write to the output file stream. */
            	while ((c = in.read()) != -1) {
            		out.write(c);
            }
        } 
        finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
    
    /**
	 * Copies input file content to the output file, one character at the time. 
	 * <p>
	 * 	The method uses the following character stream classes:
	 * 	<ol>
	 * 		<li>FileReader</li>
	 * 		<li>FileWriter</li>
	 * 	</ol> 
	 * </p>
	 * @param inFileName - The input file name.
	 * @param outFileName - The output file name.
	 * @throws IOException
	 */
	public void copyCharacterStream (String inFileName, String outFileName) throws IOException {
		   
		 FileReader inputStream = null;
	     FileWriter outputStream = null;
	     
	     String inFilePath = this.getFilePath(inFileName);
	     String outFilePath = this.getFilePath(outFileName);
	
		try {
			
			/* Instantiate the input character stream. */
			inputStream = new FileReader(inFilePath);
		
			/* Instantiate the output character stream. */
			outputStream = new FileWriter(outFilePath);
			
			int c;
	           while ((c = inputStream.read()) != -1) {
	                outputStream.write(c);
	           }
		} 
		finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}	
	}
    
    
	/**
	 * Copies input file content to the output file, one line at the time. 
	 * <p>
	 * 	The method uses the following buffered stream classes:
	 * 	<ol>
	 * 		<li>BufferedReader</li>
	 * 		<li>PrintWriter</li>
	 * 	</ol> 
	 * </p>
	 * FileReader and FileWriter handle one character at the time.
	 * To handle a line this method buffers both FileReader and FileWriter 
	 * using BufferedReader and PrintWriter respectively.
	 * @param inFileName - The input file name.
	 * @param outFileName - The output file name.
	 * @throws IOException
	 */
	public void copyBufferedStream (String inFileName, String outFileName) throws IOException {
		   
		BufferedReader inputStream = null;
		PrintWriter outputStream = null;
		
		String inFilePath = this.getFilePath(inFileName);
	    String outFilePath = this.getFilePath(outFileName);
	
		try {
			
			/* Instantiate the input buffer line stream. */
			inputStream = new BufferedReader(new FileReader(inFilePath));
	
			/* Instantiate the output buffer line stream. */
			outputStream = new PrintWriter(new FileWriter(outFilePath));
	
			String l;
			while ((l = inputStream.readLine()) != null) {
				outputStream.println(l);
	     }
		} 
		finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}	
	}

    
}
