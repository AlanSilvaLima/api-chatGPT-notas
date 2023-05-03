package br.com.alansilva.springbootchatgpt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class StudyNotesController {
    @Autowired
    private StudyNotesServiceChatGPT service;

    @PostMapping("study-notes")
    public Mono<String> createStudyNotes(@RequestBody String topic) {
        return service.createStudyNotes(topic).map(
            response -> response.choices().get(0).text());
    }
}
