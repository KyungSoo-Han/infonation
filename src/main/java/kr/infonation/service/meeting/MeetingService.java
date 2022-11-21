package kr.infonation.service.meeting;

import kr.infonation.repository.meeting.MeetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MeetingService {

    private final MeetingRepository meetingRepository;

}
