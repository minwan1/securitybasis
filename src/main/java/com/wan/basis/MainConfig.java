///*
// * Copyright 2013 the original author or authors.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *      http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
package com.wan.basis;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;

/**
 * Main configuration class for the application.
 * Turns on @Component scanning, loads externalized application.properties, and sets up the database.
 * @author Keith Donald
 */
//@Configuration
//@ComponentScan(basePackages = "com.wan", excludeFilters = { @Filter(Configuration.class) })
//public class MainConfig {
//
//	@Bean
//	public BasicDataSource dataSource() {
//		BasicDataSource ds = new BasicDataSource();
//		ds.setDriverClassName("com.mysql.jdbc.Driver");
//		ds.setUrl("jdbc:mysql://localhost:3306/spring?autoReconnect=true&useSSL=false");
//		ds.setUsername("root");
//		ds.setPassword("1234");
//		ds.setInitialSize(5);
//		return ds;
//	}


//}

