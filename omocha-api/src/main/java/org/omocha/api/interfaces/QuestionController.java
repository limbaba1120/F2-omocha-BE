package org.omocha.api.interfaces;

import static org.omocha.domain.exception.code.QnACode.*;

import org.omocha.api.application.QnaFacade;
import org.omocha.api.common.auth.jwt.UserPrincipal;
import org.omocha.api.common.response.ResultDto;
import org.omocha.api.interfaces.dto.QuestionDto;
import org.omocha.api.interfaces.mapper.QuestionDtoMapper;
import org.omocha.domain.auction.qna.QuestionCommand;
import org.omocha.domain.auction.qna.QuestionInfo;
import org.omocha.domain.common.util.PageSort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/question")
public class QuestionController {

	private final QnaFacade qnaFacade;
	private final QuestionDtoMapper questionDtoMapper;
	private final PageSort pageSort;

	// TODO : QueryDSL JOIN 관련 수정 필요
	@GetMapping("/{auctionId}/qna-list")
	public ResponseEntity<ResultDto<Page<QuestionDto.QnaListResponse>>> qnaList(
		@PathVariable(value = "auctionId") Long auctionId,
		@RequestParam(value = "sort", defaultValue = "createdAt") String sort,
		@RequestParam(value = "direction", defaultValue = "ASC") String direction,
		@PageableDefault(page = 0, size = 10)
		Pageable pageable
	) {

		log.info("Received qnaList request: {}", auctionId);

		Pageable sortPage = pageSort.sortPage(pageable, sort, direction);

		QuestionCommand.RetrieveQnas retrieveQnasCommand = questionDtoMapper.toCommand(auctionId);

		Page<QuestionInfo.RetrieveQnas> qnaResponseList = qnaFacade.retrieveQnas(retrieveQnasCommand, sortPage);

		Page<QuestionDto.QnaListResponse> qnaListResponse = questionDtoMapper.toResponse(qnaResponseList);

		log.info("qnaList finished ");

		ResultDto<Page<QuestionDto.QnaListResponse>> resultDto = ResultDto.res(
			QNA_LIST_ACCESS_SUCCESS.getStatusCode(),
			QNA_LIST_ACCESS_SUCCESS.getResultMsg(),
			qnaListResponse
		);

		return ResponseEntity
			.status(QNA_LIST_ACCESS_SUCCESS.getHttpStatus())
			.body(resultDto);
	}

	@PostMapping()
	public ResponseEntity<ResultDto<QuestionDto.QuestionAddResponse>> questionAdd(
		@AuthenticationPrincipal UserPrincipal userPrincipal,
		@RequestBody QuestionDto.QuestionAddRequest questionAddRequest
	) {
		log.info("Received questionAdd request: {}", questionAddRequest);

		Long memberId = userPrincipal.getId();

		QuestionCommand.AddQuestion addQuestionCommand = questionDtoMapper.toCommand(memberId, questionAddRequest);

		QuestionInfo.AddQuestion addQuestionInfo = qnaFacade.addQuestion(addQuestionCommand);

		QuestionDto.QuestionAddResponse questionAddResponse = questionDtoMapper.toResponse(addQuestionInfo);

		ResultDto<QuestionDto.QuestionAddResponse> resultDto = ResultDto.res(
			QUESTION_CREATE_SUCCESS.getStatusCode(),
			QUESTION_CREATE_SUCCESS.getResultMsg(),
			questionAddResponse
		);

		log.info("questionAdd finished questionAddResponse : {}", questionAddResponse);

		return ResponseEntity
			.status(QUESTION_CREATE_SUCCESS.getHttpStatus())
			.body(resultDto);

	}

	@PatchMapping("/{questionId}")
	public ResponseEntity<ResultDto<QuestionDto.QuestionModifyResponse>> questionModify(
		@AuthenticationPrincipal UserPrincipal userPrincipal,
		@PathVariable(value = "questionId") Long questionId,
		@RequestBody QuestionDto.QuestionModifyRequest questionModifyRequest
	) {

		log.info("Received questionModify request: {}", questionModifyRequest);

		Long memberId = userPrincipal.getId();

		QuestionCommand.ModifyQuestion modifyQuestionCommand = questionDtoMapper.toCommand(
			memberId,
			questionId,
			questionModifyRequest
		);

		QuestionInfo.ModifyQuestion modifyQuestionInfo = qnaFacade.modifyQuestion(modifyQuestionCommand);

		QuestionDto.QuestionModifyResponse questionModifyResponse = questionDtoMapper.toResponse(modifyQuestionInfo);

		ResultDto<QuestionDto.QuestionModifyResponse> resultDto = ResultDto.res(
			QUESTION_MODIFY_SUCCESS.getStatusCode(),
			QUESTION_MODIFY_SUCCESS.getResultMsg(),
			questionModifyResponse
		);

		log.info("questionModify finished questionModifyResponse : {}", questionModifyResponse);

		return ResponseEntity
			.status(QUESTION_MODIFY_SUCCESS.getHttpStatus())
			.body(resultDto);

	}

	@DeleteMapping("/{questionId}")
	public ResponseEntity<ResultDto<Void>> questionRemove(
		@AuthenticationPrincipal UserPrincipal userPrincipal,
		@PathVariable(value = "questionId") Long questionId
	) {

		log.info("Received questionRemove request: {}", questionId);

		Long memberId = userPrincipal.getId();

		QuestionCommand.RemoveQuestion removeQuestionCommand = questionDtoMapper.toCommand(memberId, questionId);

		qnaFacade.removeQuestion(removeQuestionCommand);

		ResultDto<Void> resultDto = ResultDto.res(
			QUESTION_DELETE_SUCCESS.getStatusCode(),
			QUESTION_DELETE_SUCCESS.getResultMsg()
		);

		log.info("questionRemove finished ");

		return ResponseEntity
			.status(QUESTION_DELETE_SUCCESS.getStatusCode())
			.body(resultDto);
	}

}
