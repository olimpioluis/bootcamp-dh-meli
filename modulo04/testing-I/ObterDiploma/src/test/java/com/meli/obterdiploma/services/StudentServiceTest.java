package com.meli.obterdiploma.services;

import com.meli.obterdiploma.exception.StudentNotFoundException;
import com.meli.obterdiploma.model.StudentDTO;
import com.meli.obterdiploma.model.SubjectDTO;
import com.meli.obterdiploma.repository.IStudentDAO;
import com.meli.obterdiploma.repository.IStudentRepository;
import com.meli.obterdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

public class StudentServiceTest {
    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    private StudentService sut;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
        this.sut = new StudentService(studentDAO, studentRepository);
    }

    @Test
    public void shouldCreateStudent() {
        SubjectDTO subject1 = new SubjectDTO("Matematica", 9D);
        SubjectDTO subject2 = new SubjectDTO("Fisica", 7D);

        StudentDTO student = StudentDTO.builder().id(1L).studentName("Luis").subjects(Arrays.asList(subject1, subject2)).build();

        Mockito.when(this.studentDAO.findById(Mockito.any())).thenReturn(student);

        this.sut.create(student);

        StudentDTO studentFound = this.studentDAO.findById(student.getId());

        Assertions.assertEquals(student, studentFound);
    }

    @Test
    public void shouldNotCreateStudentWithoutData() {
        Mockito.when(this.studentDAO).thenThrow();

        StudentDTO studentFound = this.studentDAO.findById(student.getId());

        Assertions.assertEquals(student, studentFound);
    }
}
