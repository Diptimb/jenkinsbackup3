package com.mindtree.movies.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.mindtree.movies.entity.Actor;
import com.mindtree.movies.entity.Movie;
import com.mindtree.movies.exceptions.ApplicationException;
import com.mindtree.movies.exceptions.ServiceException;
import com.mindtree.movies.service.ActorService;
import com.mindtree.movies.service.ActorServiceImpl;
import com.mindtree.movies.service.MovieService;
import com.mindtree.movies.service.MovieServiceImpl;
import com.mindtree.movies.utility.KeyboardUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AppRunner {
	public static void main(String[] args) throws IOException {
		List<Actor> actors = new ArrayList<Actor>();
		List<Movie> movie1 = new ArrayList<Movie>();
		KeyboardUtils key = new KeyboardUtils();
		MovieService m = new MovieServiceImpl();
		ActorService a = new ActorServiceImpl();
		int flag = 1;
		do {
			System.out.println("enter one choice");
			System.out.println("------------------");
			System.out.println(
					"1.Actors of a particular movie \n2.Movies of a particular Actor\n3.Movies based on Budget\n4.Count of actors\n5.Sorted Actors based on renumeration\n6.Exit");
			int choice = key.readInteger();
			switch (choice) {
			case 1:

				getMoviesOfActor(key, m);
				break;
			case 2:
				System.out.println("enter actor id");
				int id1 = key.readInteger();
				if (id1 != -999) {
					try {
						movie1 = a.triggMovieView(id1);
						for (Movie mo : movie1) {
							System.out.println(mo.toString());
						}
					} catch (ServiceException e) {
						try {
							throw new ApplicationException(e.getLocalizedMessage(), e);
						} catch (ApplicationException e2) {
							System.out.println(e2.getMessage());
						}
					}
				}
				break;
			case 3:
				try {
					XSSFWorkbook workbook = new XSSFWorkbook(); 
			       
			        XSSFSheet sheet = workbook.createSheet("movie data");
					movie1 = m.triggMovieBudget();
					int rownum = 0;
					for (Movie mo : movie1) {
			        
			            Row row = sheet.createRow(rownum++);
			    
			            int cellIndex = 1;
			            row.createCell(cellIndex++).setCellValue(mo.getMovie_id());
			            row.createCell(cellIndex++).setCellValue(mo.getMovie_name());
			 
			            //third place in row is marks in Science
			            row.createCell(cellIndex++).setCellValue(mo.getBudget());
			 
			         
			            }
			            FileOutputStream out;
						try {
							File file = new File("movie.xlsx"); 
							out = new FileOutputStream(file);
							workbook.write(out);
				            out.close();
						} catch (FileNotFoundException e) {
							System.out.println(e.getLocalizedMessage());
						}
			          
			        }
				 catch (ServiceException e) {
					try {
						throw new ApplicationException(e.getLocalizedMessage(), e);
					} catch (ApplicationException e2) {
						System.out.println(e2.getMessage());
					}
				}

				break;
			case 4:
				try {
					actors = a.triggActorCount();
					System.out.println("jkjk");
					// System.out.println(actors.size());
					for (Actor act : actors) {
						System.out.println();
						System.out.println(act.toString1());
					}
				} catch (ServiceException e) {
					try {
						throw new ApplicationException(e.getLocalizedMessage(), e);
					} catch (ApplicationException e2) {
						System.out.println(e2.getMessage());
					}
				}

				break;
			case 5:
				try {
					actors = a.triggActorSort();
					for (Actor act : actors) {
						System.out.println(act.toString());
					}
				} catch (ServiceException e) {
					try {
						throw new ApplicationException(e.getLocalizedMessage(), e);
					} catch (ApplicationException e2) {
						System.out.println(e2.getMessage());
					}
				}

				break;
			case 6:
				System.out.println("Thank you!!!!");
				flag = 0;
				break;
			case 7 :
				try{
					FileInputStream file = new FileInputStream(new File("movie.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) 
            {     Row nextRow = rowIterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
             
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                 
                switch (cell.getCellType()) {
                case Cell.CELL_TYPE_NUMERIC:
                    System.out.print(cell.getNumericCellValue());
                    break;
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue());
                        break;
                   
                }
                System.out.print(" - ");
            }
            System.out.println();
            }
            file.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
			default:
				System.out.println("enter a valid choice");

			}
		} while (flag != 0);
	}

	private static void getMoviesOfActor(KeyboardUtils key, MovieService m) {
		List<Movie> movie1;
		System.out.println("enter movie id");
		int id = key.readInteger();
		
		if (id != -999) {
			try {
				movie1 = m.triggMovieView(id);
				for (Movie mo : movie1) {
					System.out.println(mo.toString());
				}
			} catch (ServiceException e) {
				try {
					throw new ApplicationException(e.getLocalizedMessage(), e);
				} catch (ApplicationException e2) {
					System.out.println(e2.getMessage());
				}
			}
		}
	}
}