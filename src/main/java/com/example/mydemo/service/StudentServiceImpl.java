package com.example.mydemo.service;

import com.example.mydemo.dto.requestDto.StudentRequestDto;
import com.example.mydemo.dto.responseDto.StudentResponseDto;
import com.example.mydemo.model.Student;
import com.example.mydemo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public Student addUser(StudentRequestDto studentRequestDto) {
   //We can use Mapper as well for next two lines
    Student student=new Student();
    student.setName(studentRequestDto.getName());

        return studentRepository.save(student);
    }

    @Override
    public List<StudentResponseDto> getAllStudents()
    {
        List<Student> students=studentRepository.findAll();

        List<StudentResponseDto> studentResponseDto= new ArrayList<>();

        for(Student student:students)
        {
            StudentResponseDto responseDto = new StudentResponseDto();
            //setting student details in the response dto
//            responseDto.setName(student.getName());
            responseDto.setName(student.getName());
            //add data to the dto list
            studentResponseDto.add(responseDto);


        }

return studentResponseDto;
//        return studentRepository.findAll();
    }

    @Override
    public Student getStudentbyId(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException
                ("Student does not exist by given id" + id));
    }

    public String updateStudent(Long id, StudentRequestDto studentrequestDto) {
        Student existingStudent = studentRepository.findById(id).
                orElseThrow(() -> new RuntimeException("student not found"));
        existingStudent.setName(studentrequestDto.getName());
        studentRepository.save(existingStudent);
        return "Student updated successfully";
    }

    @Override
    public String deleteStudent(Long id) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("student not found"));
        studentRepository.deleteById(id);
        return "student with id" + id + "deleted successfully";

    }
}
