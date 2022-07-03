# Contributing
- [References](#ref)
- [컨트리뷰트 가이드라인](#submission)
- [코드 규칙](#coderules)
- [커밋 메시지 형식](#cmconv)

## <a name="ref"></a>References

## <a name="submission"></a>컨트리뷰트 가이드라인 
### Issue
만약에 버그, 기능 추가 등의 이슈 등록이 필요한 상황이 있을 경우, 먼저 해당 이슈가 이미 존재하는지 확인하여 가능한 한 중복을 피해주시기 바랍니다.

만약 버그로 인해 이슈를 작성하고자 한다면, 해당 버그가 발생하게 된 경위, 버그 발생 순서, 버그 실현을 위한 절차, 버그 발생 시 남겨진 로그나 스크린샷 등을 첨부하여 버그의 원인을 찾는 데 도움을 주십시오.

이슈는 반드시 이슈 템플릿을 사용하여 작성하시기 바랍니다.
### Pull Request
Pull Request를 등록하기 전에, 반드시 다음 요소들을 확인하세요.

1. 이미 관련 PR이 존재하는지 확인하세요.
2. PR이 해결하고자 하는 이슈가 존재하는지 확인하세요.
3. Fork한 레포지토리에서 PR한 것인지 확인하세요.
4. 반드시 Feature Branch를 만든 후 작업하시고, Feature Branch로 Pull Requst하시기 바랍니다.
5. 반드시 PR에서는 그에 상응하는 테스트 케이스도 같이 커밋하시기 바랍니다.
6. [코드 규칙](#coderules)을 따랐는지 확인하세요.
7. [커밋 메시지 형식](#cmconv)이 따라졌는지 반드시 확인하세요.
8. 한 PR당 코드 단위를 최대한 줄여주시기 바랍니다. 200~800줄 정도가 바람직합니다.
9. 깃허브에서, 자신이 개발한 기능의 Develop 브랜치로 PR하시기 바랍니다.<br>
    예시 1: backend 코드를 개발했을 경우 - `2022-StudyMatching:develop-backend`<br>
    예시 2: frontend 코드를 개발했을 경우 - `2022-StudyMatching:develop-frontend`

## <a name="coderules"></a>코드 규칙
- 모든 소스코드는 **반드시 테스트되어야** 합니다.
- 모든 API Endpoint는 **반드시 문서화되어야** 합니다.
- Linter가 존재한다면, 해당 개발 section의 linter 옵션을 따라 개발하시기 바랍니다.

## <a name="cmconv"></a>커밋 메시지 형식
커밋 메시지는 Angular의 [Conventional Commit rules](https://github.com/angular/angular/blob/main/CONTRIBUTING.md#-commit-message-format)를 일부분 따르며, 아래 내용은 이를 번역/수정한 것입니다.

커밋 메시지 검사가 필요하다면 [Commitlint Online](https://commitlint.io/)을 사용하시기 바랍니다.

각 커밋 메시지는 header, body, footer가 존재합니다.
```
<header>
<BLANK LINE>
<body>
<BLANK LINE>
<footer>
```
### Header
```
<type>(<scope>): <short summary>
  │       │             │
  │       │             └─⫸ Summary in present tense. Not capitalized. No period at the end.
  │       │
  │       └─⫸ Commit Scope: Parent Package/folder name(ex. controller, entity)
  │
  └─⫸ Commit Type: build|project|docs|feat|fix|perf|refactor|test
```
#### Type
- build: 빌드에 영향을 미치는 변경(디펜던시 추가, 빌드 설정 변경, 새 스크립트 추가 등)
- project: 레포지토리 설정(CI, Template 설정 등)파일 변경
- docs: 문서화 관련 변경
- feat: 새 기능 추가
- fix: 버그 수정
- perf: 최적화
- refactor: 소스코드 구조 변경 등 기능 추가나 버그 수정과 관계없는 변경
- test: test case 추가

#### Scope
scope에는 변경된 부분의 패키지 네임을 입력하시기 바랍니다.

#### Short Summary
짧게, 이 커밋이 변경하는 내용에 대한 간략한 설명을 추가하시기 바랍니다.
- 가능한 한, 현재형/명령형으로 작성하세요(added, adds, 추가했습니다 대신 add, 추가 등)
- 영어 사용 시, 첫 글자는 대문자가 필요하지 않습니다.
- 문장 끝에 .를 찍지 않습니다.

### Body
body에서는 당신이 왜 이런 커밋을 작성했는지에 대해 Header의 summary처럼 작성하시기 바랍니다. 만약 필요하다면, 이전의 소스 코드 동작 등을 추가적으로 작성하여 소스 코드의 변경을 강조할 수 있습니다.

### Footer
footer는 Breaking Changes, Deprecated change, Issue close 등을 포함하기 위해 사용하며, 각각 다음과 같습니다.
```
BREAKING CHANGE: <breaking change summary>
<BLANK LINE>
<breaking change 설명 + 마이그레이션 설명>
<BLANK LINE>
<BLANK LINE>
Fixes #<issue 번호>
``` 
또는
```
DEPRECATED: <Deprecated 된 메소드/클래스 등>
<BLANK LINE>
<적용된 이유, 업데이트 방법>
<BLANK LINE>
<BLANK LINE>
closes #<PR 번호>
```