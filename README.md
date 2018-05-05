# DisplayPreferenceColorOnRightSide
Preferenceでカラー設定をする方法、および、設定項目の右側に設定色を表示する方法。
要点としては、
- XXXXPreferenceクラスの派生クラスを作成する。
- onCreateView関数をオーバーライドし、setWidgetLayoutResource関数で、TextViewを登録する。
- onBindView関数をオーバーライドし、textView.setText関数で、TextViewにPreference値を設定する。

## Screenshots : スクリーンショット
<img src="images/Screenshot_01.png" width="256" alt="Screenshot"/> <img src="images/Screenshot_02.png" width="256" alt="Screenshot"/> <img src="images/Screenshot_03.png" width="256" alt="Screenshot"/> <img src="images/Screenshot_04.png" width="256" alt="Screenshot"/> <img src="images/Screenshot_05.png" width="256" alt="Screenshot"/>

## Requirements : 必要条件、依存関係
- Android Studio 2.3.3
- Android SDK 25
- Android Build Tools v26.0.0
- Android Support Repository

## Author : 作者
Nobuki HIRAMINE : [http://www.hiramine.com](http://www.hiramine.com)

## License : ライセンス
```
Copyright 2018 Nobuki HIRAMINE

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
