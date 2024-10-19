//package com.ghosttrio.judomanager.board.board.service;
//
//import com.judomanager.common.exception.JMException;
//import com.ghosttrio.judomanager.board.board.domain.Board;
//import com.ghosttrio.judomanager.board.board.domain.Post;
//import com.ghosttrio.judomanager.board.board.repository.BoardRepository;
//import com.ghosttrio.judomanager.board.board.repository.PostRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//import static com.judomanager.common.exception.ErrorCode.POST_NOT_FOUND;
//
//@Service
//@RequiredArgsConstructor
//@Transactional(readOnly = true)
//public class LoadBoardService {
//    private final PostRepository postRepository;
//    private final BoardRepository boardRepository;
//
//    public List<Post> findAllPost(Long boardId){
//        return postRepository.findAllPostByBoardId(boardId);
//    }
//
//    public Post findPost(Long postId){
//        return postRepository.findById(postId)
//                .orElseThrow(() -> new JMException(ErrorCode.POST_NOT_FOUND));
//    }
//
//    public List<Board> findAll(){
//        return boardRepository.findAll();
//    }
//
//}
