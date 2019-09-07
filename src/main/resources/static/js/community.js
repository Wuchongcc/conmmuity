function post() {
    var questionId = $("#question_id").val();
    var content = $("#comment_content").val();
    commentRestructure(questionId, content, 1);
}

function commentRestructure(question_id, content, type) {
    if (!content) {
        alert("回复内容不能为空。");
        return;
    }
    $.ajax({
        type: "POST",
        url: "/comment",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify({
            "parentId": question_id,
            "content": content,
            "type": type
        }),
        success: function (response) {
            if (response.code == 200) {
                window.location.reload();
            } else {
                if (response.code == 2002) {
                    var isAccepted = confirm(response.message);
                    if (isAccepted) {
                        window.open("https://github.com/login/oauth/authorize?client_id=c4e831221e1cad6238d5&redirect_uri=" + document.location.origin + "/logincallback&scope=user&state=1");
                        window.localStorage.setItem("closable", true);
                    }
                } else {
                    alert(response.message);
                }
            }
        }
    });
}

function comment(e) {
    var commentId = e.getAttribute("data-id");
    var comments = $("#input-" + commentId).val();
    commentRestructure(commentId, comments, 2);
}

function collapseComments(e) {
    var id = e.getAttribute("data-id");
    var comments = $("#comment-" + id);

    // 获取一下二级评论的展开状态
    var collapse = e.getAttribute("data-collapse");
    if (collapse) {
        // 折叠二级评论
        comments.removeClass("in");
        e.removeAttribute("data-collapse");
        e.classList.remove("active");
    } else {
        var subCommentContainer = $("#comment-" + id);
        if (subCommentContainer.children().length != 1) {
            //展开二级评论
            comments.addClass("in");
            // 标记二级评论展开状态
            e.setAttribute("data-collapse", "in");
            e.classList.add("active");
        } else {
            $.getJSON("/comment/" + id, function (data) {
                $.each(data.data.reverse(), function (index, comment) {
                    var mediaLeftElement = $("<div/>", {
                        "class": "media-left"
                    }).append($("<img/>", {
                        "class": "media-object img-rounded",
                        "src": comment.user.avatarUrl
                    }));

                    var mediaBodyElement = $("<div/>", {
                        "class": "media-body"
                    }).append($("<h5/>", {
                        "class": "media-heading",
                        "html": comment.user.name
                    })).append($("<div/>", {
                        "html": comment.content
                    })).append($("<div/>", {
                        "class": "menu"
                    }).append($("<span/>", {
                        "class": "pull-right",
                        "html": moment(comment.gmt_create).format('YYYY-MM-DD')
                    })));
                    var mediaElement = $("<div/>", {
                        "class": "media"
                    }).append(mediaLeftElement).append(mediaBodyElement);

                    var commentElement = $("<div/>", {
                        "class": "col-lg-12 col-md-12 col-sm-12 col-xs-12 comments"
                    }).append(mediaElement);

                    subCommentContainer.prepend(commentElement);
                });
                //展开二级评论
                comments.addClass("in");
                // 标记二级评论展开状态
                e.setAttribute("data-collapse", "in");
                e.classList.add("active");
            });
        }
    }
}
//点赞功能
function like_count(e){
    var commentId = e.getAttribute("data-id");
    var userId = $(".commentor").attr("value");
    var likecountId = $("#likecount-" + commentId);
    $.ajax({
        type: "POST",
        url: "/likecount",
        dataType: "text",
        contentType: "application/json",
        data: JSON.stringify({
            "comment_id": commentId,
            "user_id": userId
        }),
        success:function(data) {
            if(data == "Nologin"){
                alert("请登录后再点赞。谢谢！");
            }
            //点赞成功+1
            if (data == "likeUp") {
                var a = parseInt(likecountId.html());
                a++;
                likecountId.html(a);
            //取消点赞-1
            }else if (data == "likeDown"){
                var a = parseInt(likecountId.html());
                a--;
                likecountId.html(a);
            }
        }
    });
}
function showSelectTag(){
    $("#select-tag").show();
}

function selectTag(e){
    var value = e.getAttribute("data-tag");
    var previous = $("#tag").val();
    if (previous.indexOf(value) == -1) {//查找数组种的元素从1到n
        if (previous) {
            $("#tag").val(previous + ',' + value);
        } else {
            $("#tag").val(value);
        }
    }
}