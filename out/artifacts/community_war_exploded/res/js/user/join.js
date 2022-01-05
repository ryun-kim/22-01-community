{
    let idChkState = 2; // 0: 아이디 사용 불가능, 1: 아이디 사용가능, 2: 체크 안함
    const joinFrmElem = document.querySelector('#join-Frm');

    const setIdChkMsg = (data) => {
        idChkState =data.result; // 0 아니면 1

        const idChkMsgElem = joinFrmElem.querySelector('#id-Chk-Msg');
        switch (data.result){
            case 0:
                idChkMsgElem.innerText='이미 사용중인 아이디입니다.';
                break;
            case 1:
                idChkMsgElem.innerText='사용할 수 있는 아이디 입니다.';
                break;
        }
    }

    if(joinFrmElem){


        joinFrmElem.addEventListener('submit', (e)=>{
            if(idChkState !== 1){
                switch (idChkState){
                    case 0:
                        alert('다른 아이디를 사용해 주세요');
                        break;
                    case 2:
                        alert('아이디 중복 체크를 해주세요!');
                        break;
                }
                e.preventDefault();
            }
        })

        joinFrmElem.uid.addEventListener('keyup',()=>{
            const idChkMsgElem = joinFrmElem.querySelector('#id-Chk-Msg');
            idChkMsgElem.innerText ='';
            idChkState =2;
        })

        //아이디 중복 체크 버튼

        const idBtnChkElem = joinFrmElem.querySelector('#id-btn-chk');
        idBtnChkElem.addEventListener('click',() =>{
            const idVal = joinFrmElem.uid.value;
            if(idVal.length < 4){
                alert('아이디는 4자 이상 작성해 주세요.');
                return;
            }
            fetch(`/user/idChk/${idVal}`)
                .then(res => res.json())
                .then((data) => {
                    setIdChkMsg(data);
                }).catch((e)=> {
                    console.log(e);
                });
        });

    }
}