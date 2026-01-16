package com.example.nasda.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void sendTemporaryPassword(String to, String tempPassword) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to); // 사용자가 가입할 때 쓴 지메일 또는 네이버 주소
        message.setSubject("[나의 영감 저장소] 임시 비밀번호 안내");
        message.setText("안녕하세요. 요청하신 임시 비밀번호는 다음과 같습니다.\n\n" +
                "임시 비밀번호: " + tempPassword + "\n\n" +
                "로그인 후 계정 관리에서 반드시 비밀번호를 변경해 주세요.");
        message.setFrom("taemin3429@naver.com");

        mailSender.send(message);
    }
}