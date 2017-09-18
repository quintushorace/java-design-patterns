/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Piyush Chaudhari
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.iluwatar.unitofwork;

import java.util.HashMap;
import java.util.List;

/**
 * {@link StudentManagementApp} Application for managing student data.
 */
public class StudentManagementApp {
  /**
   *
   * @param args no argument sent
   */
  public static void main(String[] args) {
    Student ram = new Student(1, "Ram", "Street 9, Cupertino");
    Student shyam = new Student(2, "Shyam", "Z bridge, Pune");
    Student gopi = new Student(3, "Gopi", "Street 10, Mumbai");

    HashMap<String, List<Student>> context = new HashMap<>();
    StudentDatabase studentDatabase = new StudentDatabase();
    StudentRepository studentRepository = new StudentRepository(context, studentDatabase);

    studentRepository.registerNew(ram);
    studentRepository.registerModified(shyam);
    studentRepository.registerDeleted(gopi);
    studentRepository.commit();
  }
}
