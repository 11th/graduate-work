package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.ResponseWrapperCommentDto;

import java.util.Collection;

@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RestController
@Tag(name = "Комментарии")
public class CommentController {
    @PostMapping("/adds/{id}/comments")
    @Operation(summary = "Добавить комментарий к объявлению", responses = {
            @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(
                    implementation = CommentDto.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "401", content = {@Content(schema = @Schema())})}
    )
    public ResponseEntity<CommentDto> create(@PathVariable("id") Integer id,
                                             @RequestBody String text) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/adds/{adId}/comments/{commentId}")
    @Operation(summary = "Удалить комментарий", responses = {
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "401", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())})}
    )
    public ResponseEntity<?> delete(@PathVariable("adId") Integer adId,
                                    @PathVariable("commentId") Integer commentId) {
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/adds/{adId}/comments/{commentId}")
    @Operation(summary = "Обновить комментарий", responses = {
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(
                    implementation = CommentDto.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "401", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())})}
    )
    public ResponseEntity<CommentDto> update(@PathVariable("adId") Integer adId,
                                             @PathVariable("commentId") Integer commentId,
                                             @RequestBody CommentDto comment) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/adds/{id}/comments")
    @Operation(summary = "Получить комментарии объявления", responses = {
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(
                    implementation = ResponseWrapperCommentDto.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "401", content = {@Content(schema = @Schema())})}
    )
    public ResponseEntity<ResponseWrapperCommentDto> findAllByAdvert(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().build();
    }
}