document.addEventListener("DOMContentLoaded", () => {
  //modal
  const backdrop = document.getElementById("modalBackdrop");
  const modal1 = document.getElementById("findUserModal");
  const modal2 = document.getElementById("resetPasswordModal");
  
  document.querySelector(".pwdReset").addEventListener("click", () => {
      backdrop.classList.remove("hidden");
      modal1.classList.remove("hidden");
  
      setTimeout(() => {
        document.getElementById("name").focus();
      },0);
  });
  
  function closeModal() {
    backdrop.classList.add("hidden");
    modal1.classList.add("hidden");
    modal2.classList.add("hidden");
  }
  window.closeModal = closeModal;

  //user check
  document.getElementById("checkUserBtn").addEventListener('click', async () => {
    const name = document.getElementById("name").value.trim();
    const sabun = document.getElementById("sabun").value.trim();
  
    const response = await fetch("/users/findByUsers", {
      method: "POST",
      headers: {"Content-Type": "application/json"},
      body: JSON.stringify({name: name, sabun: sabun})
    });
    const data = await response.text();
    
    if (data === "success") {
      modal1.classList.add("hidden");
      modal2.classList.remove("hidden");
  
      document.getElementById("hiddenName").value = name;
      document.getElementById("hiddenSabun").value = sabun;
  
      setTimeout(() => {
        document.getElementById("newPw").focus();
      },0);
    } else {
      document.getElementById("findUserError").style.display = "block";
    }
  });
  
  //password change submit
  const pwForm = document.getElementById("pwForm");
  pwForm.addEventListener("submit", (e) => {
    e.preventDefault();
    
    const pw1 = document.getElementById("newPw").value.trim();
    const pw2 = document.getElementById("newPw2").value.trim();
    const pwError = document.getElementById("pwError");
  
    pwError.style.display = "none";
    pwError.textContent = "";
  
    if (pw1 !== pw2) {
        pwError.textContent = "비밀번호가 서로 일치하지 않습니다.";
        pwError.style.display = "block";
        return;
    }
  
    const regex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,20}$/;
    if (!regex.test(pw1)) {
        pwError.textContent = "8~20자, 영문/숫자/특수문자를 모두 포함해야 합니다.";
        pwError.style.display = "block";
        return;
    }
    alert("비밀번호 변경이 완료되었습니다.");
    pwForm.submit();
  });
})


