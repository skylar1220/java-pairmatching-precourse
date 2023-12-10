package pairmatching.domain;

import java.util.List;
import java.util.Objects;

public class CurriculumDetail {

    private final Course course;
    private final Level level;
    private final Mission mission;

    public CurriculumDetail(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public static CurriculumDetail of(List<String> curriculumDetail) {
        String course = curriculumDetail.get(0);
        String level = curriculumDetail.get(1);
        String mission = curriculumDetail.get(2);
        return new CurriculumDetail(Course.from(course), Level.from(level), Mission.of(Level.from(level), mission));
    }

    public Level getLevel() {
        return level;
    }

    public boolean isBackEnd() {
        return course.isBackEnd();
    }

    public boolean isSameLevel(CurriculumDetail inpuCurriculumDetail) {
        return this.level.equals(inpuCurriculumDetail.level);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CurriculumDetail that = (CurriculumDetail) o;
        return course == that.course && level == that.level && mission == that.mission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, mission);
    }
}
