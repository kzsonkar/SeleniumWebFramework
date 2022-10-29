package com.karan.orangehrm.fixtures.template;

import com.karan.orangehrm.fixtures.entity.AddEmployeeData;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class AddEmployeeTemplate implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(AddEmployeeData.class).addTemplate("mandatories", new Rule() {
			{
				add("firstName", random("Karan", "Sweta"));
				add("middleName", random("H", "H", "H"));
				add("lastName", random("Sonkar", "Sonkar", "Sonkar"));
				add("nickName", random("Dude", "Smart", "Goku"));
				add("employeeId", random(3938, 707, 1433, 146));
			}
		});
	}

}
