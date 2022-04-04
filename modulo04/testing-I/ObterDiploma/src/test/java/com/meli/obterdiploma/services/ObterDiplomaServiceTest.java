package com.meli.obterdiploma.services;

import com.meli.obterdiploma.exception.StudentNotFoundException;
import com.meli.obterdiploma.model.StudentDTO;
import com.meli.obterdiploma.model.SubjectDTO;
import com.meli.obterdiploma.repository.IStudentDAO;
import com.meli.obterdiploma.service.ObterDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

public class ObterDiplomaServiceTest {

    private ObterDiplomaService sut;

    @Mock
    private IStudentDAO studentDAO;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
        this.sut = new ObterDiplomaService(studentDAO);
    }

    @Test
    public void shouldAnalyzeScores() {
        SubjectDTO subject1 = new SubjectDTO("Matematica", 9D);
        SubjectDTO subject2 = new SubjectDTO("Fisica", 7D);

        StudentDTO student = StudentDTO.builder().id(1L).studentName("Luis").subjects(Arrays.asList(subject1, subject2)).build();

        Mockito.when(this.studentDAO.findById(Mockito.any())).thenReturn(student);

        StudentDTO response = this.sut.analyzeScores(1L);

        Assertions.assertEquals(student, response);
    }

    @Test
    public void shouldNotAnalyzeScoresWithoutID() {
        Mockito.when(this.studentDAO.findById(Mockito.any())).thenThrow(new StudentNotFoundException(null));

        StudentNotFoundException response = Assertions.assertThrows(StudentNotFoundException.class, () -> this.sut.analyzeScores(null));

        Assertions.assertEquals("O aluno com Id null não está registrado.", response.getError().getDescription());

//        Outra maneira de fazer
//        try {
//            this.sut.analyzeScores(1L);
//        } catch (StudentNotFoundException ex) {
//            Assertions.assertEquals("O aluno com Id null não está registrado.", ex.getError().getDescription());
//        }
    }

    @Test
    public void shouldNotAnalyzeScoresIfIDoesNotExist() {
        Mockito.when(this.studentDAO.findById(Mockito.any())).thenThrow(new StudentNotFoundException(1L));

        StudentNotFoundException response = Assertions.assertThrows(StudentNotFoundException.class, () -> this.sut.analyzeScores(1L));

        Assertions.assertEquals("O aluno com Id 1 não está registrado.", response.getError().getDescription());
    }

    @Test
    public void shouldCalculateAverage() {
        SubjectDTO subject1 = new SubjectDTO("Matematica", 9D);
        SubjectDTO subject2 = new SubjectDTO("Fisica", 7D);

        StudentDTO student = StudentDTO.builder().id(1L).studentName("Luis").subjects(Arrays.asList(subject1, subject2)).build();

        Mockito.when(this.studentDAO.findById(Mockito.any())).thenReturn(student);

        StudentDTO response = this.sut.analyzeScores(1L);

        Assertions.assertEquals(8L, response.getAverageScore());
    }

    @Test
    public void shouldGenerateGreetingMessageCongratulations() {
        SubjectDTO subject1 = new SubjectDTO("Matematica", 10D);
        SubjectDTO subject2 = new SubjectDTO("Fisica", 10D);

        StudentDTO student = StudentDTO.builder().id(1L).studentName("Luis").subjects(Arrays.asList(subject1, subject2)).build();

        Mockito.when(this.studentDAO.findById(Mockito.any())).thenReturn(student);

        StudentDTO response = this.sut.analyzeScores(1L);

        Assertions.assertEquals("O aluno Luis obteve uma média de 10. Parabéns!", response.getMessage());
    }

    @Test
    public void shouldGenerateGreetingMessageCanBeBetter() {
        SubjectDTO subject1 = new SubjectDTO("Matematica", 5.5D);
        SubjectDTO subject2 = new SubjectDTO("Fisica", 5.5D);

        StudentDTO student = StudentDTO.builder().id(1L).studentName("Luis").subjects(Arrays.asList(subject1, subject2)).build();

        Mockito.when(this.studentDAO.findById(Mockito.any())).thenReturn(student);

        StudentDTO response = this.sut.analyzeScores(1L);

        Assertions.assertEquals("O aluno Luis obteve uma média de 5,5. Você pode melhorar.", response.getMessage());
    }
}