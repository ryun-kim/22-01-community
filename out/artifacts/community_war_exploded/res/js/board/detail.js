{
    const dataElem = document.querySelector('#data');
    const delBtnElem = document.querySelector('#delBtn');
    const modBtnElem = document.querySelector('#modBtn');
    const iboard = dataElem.dataset.iboard;

    //삭제 버튼
    if(delBtnElem) {
        delBtnElem.addEventListener('click', ()=> {
            const icategory = dataElem.dataset.icategory;
            if(confirm(msg.fnIsDel(`${iboard}번 글`))) {
                location.href=`/board/del?icategory=${icategory}&iboard=${iboard}`;
            }
        });
    }

    //수정 버튼
    if(modBtnElem){
        modBtnElem.addEventListener('click', ()=>{
            location.href=`/board/mod?iboard=${iboard}`
        })
    }

}