package com.lapis.jsfexporter.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lapis.jsfexporter.csv.CSVExportOptions;
import com.lapis.jsfexporter.primefaces.datatable.DataTableExportOptions;
import com.lapis.jsfexporter.primefaces.datatable.DataTableExportOptions.ExportRange;

@ManagedBean
@ViewScoped
public class NonLazyTableBean {

	private static final String[] COLORS = new String[]
			{"Black", "White", "Green", "Red", "Blue", "Orange", "Silver", "Yellow", "Brown", "Maroon"};
	private static final String[] MAKES = new String[]
			{"Mercedes", "BMW", "Volvo", "Audi", "Renault", "Opal", "Volkswagen", "Chrysler", "Ferrari", "Ford"};
	
	private List<Car> cars;
	
	@PostConstruct
	protected void init() {
		Random rng = new Random();
		
		cars = new ArrayList<Car>();
		for (int i = 0; i < 10; i++) {
			cars.add(new Car(MAKES[rng.nextInt(10)], COLORS[rng.nextInt(10)], 1970 + rng.nextInt(43), new BigDecimal(rng.nextInt(100000))));
		}
	}
	
	public DataTableExportOptions getDTPageOnly() {
		return new DataTableExportOptions(ExportRange.PAGE_ONLY);
	}
	
	public CSVExportOptions getCSVWithUTF8BOM() {
		CSVExportOptions options = new CSVExportOptions();
		options.setCharacterEncoding("UTF-8-with-bom");
		return options;
	}

	public List<Car> getCars() {
		return cars;
	}
	
}
