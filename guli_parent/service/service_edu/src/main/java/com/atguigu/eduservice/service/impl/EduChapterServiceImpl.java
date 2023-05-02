package com.atguigu.eduservice.service.impl;

import com.atguigu.eduservice.entity.EduChapter;
import com.atguigu.eduservice.entity.EduVideo;
import com.atguigu.eduservice.entity.chapter.ChapterVo;
import com.atguigu.eduservice.entity.chapter.VideoVo;
import com.atguigu.eduservice.mapper.EduChapterMapper;
import com.atguigu.eduservice.service.EduChapterService;
import com.atguigu.eduservice.service.EduVideoService;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2023-04-22
 */


    @Service
    public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {

        @Autowired
        private EduVideoService videoService;

        //课程大纲列表,根据课程id进行查询
        @Override
        public List<ChapterVo> getChapterVideoByCourseId(String courseId) {

            //1 根据课程id查询课程里面所有的章节
            QueryWrapper<EduChapter> wrapperChapter = new QueryWrapper<>();
            wrapperChapter.eq("course_id",courseId);
            List<EduChapter> eduChapterList = baseMapper.selectList(wrapperChapter);

            //2 根据课程id查询课程里面所有的小节
            QueryWrapper<EduVideo> wrapperVideo = new QueryWrapper<>();
            wrapperVideo.eq("course_id",courseId);
            List<EduVideo> eduVideoList = videoService.list(wrapperVideo);
            List<ChapterVo> finalList = new ArrayList<>();

            //3 遍历查询章节list集合进行封装
            //遍历查询章节list集合
            for (int i = 0; i < eduChapterList.size(); i++) {
                //每个章节
                EduChapter eduChapter = eduChapterList.get(i);
                //eduChapter对象值复制到ChapterVo里面
                ChapterVo chapterVo = new ChapterVo();
                BeanUtils.copyProperties(eduChapter,chapterVo);
                finalList.add(chapterVo);

                //创建集合，用于封装章节的小节
                List<VideoVo> videoList = new ArrayList<>();

                //4 遍历查询小节list集合，进行封装
                for (int m = 0; m < eduVideoList.size(); m++) {
                    //得到每个小节
                    EduVideo eduVideo = eduVideoList.get(m);
                    if(eduVideo.getChapterId().equals(eduChapter.getId())) {
                        VideoVo videoVo = new VideoVo();
                        BeanUtils.copyProperties(eduVideo,videoVo);
                        videoList.add(videoVo);
                    }
                }
                chapterVo.setChildren(videoList);
            }
            return finalList;
        }

        ////删除章节的方法
        @Override
        public boolean deleteChapter(String chapterId) {
            QueryWrapper<EduVideo> wrapper = new QueryWrapper<>();
            wrapper.eq("chapter_id",chapterId);
            int count = videoService.count(wrapper);
            if(count >0) {
                throw new GuliException(20001,"不能删除");
            } else {
                int result = baseMapper.deleteById(chapterId);
                return result>0;
            }
        }
    //2 根据课程id删除章节
    @Override
    public void removeChapterByCourseId(String courseId) {
        QueryWrapper<EduChapter> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id",courseId);
        baseMapper.delete(wrapper);
    }
    }


