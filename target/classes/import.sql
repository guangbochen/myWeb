--
-- JBoss, Home of Professional Open Source
-- Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
-- contributors by the @authors tag. See the copyright.txt in the
-- distribution for a full listing of individual contributors.
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
-- http://www.apache.org/licenses/LICENSE-2.0
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
--

-- You can use this file to load seed data into the database using SQL statements
--insert into Member (id, name, email, phone_number) values (0, 'John Smith', 'john.smith@mailinator.com', '2125551212') 
insert into User(id, name, password, email, DOB, country, city, street) values (0, 'admin', 'admin', 'guangbo.chen@gmail.com', '1999-07-07', 'Australia', 'Sydney', 'Ultimo')
insert into User(id, name, password, email, DOB, country, city, street) values (1, 'user1', 'password', 'user1.name@gmail.com', '1999-07-07', 'Australia', 'Sydney', 'Ultimo')
insert into User(id, name, password, email, DOB, country, city, street) values (2, 'user2', 'password', 'user2.name@gmail.com', '1999-07-07', 'Australia', 'Sydney', 'Ultimo')
insert into User(id, name, password, email, DOB, country, city, street) values (3, 'user3', 'password', 'user3.name@gmail.com', '1999-07-07', 'Australia', 'Sydney', 'Ultimo')
--insert into User(id, name, password, email, DOB) values (0, 'admin', 'admin', 'guangbo.chen@gmail.com', '1999-07-07')
