/*
 * Copyright 2017 Google
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

#import <Foundation/Foundation.h>

@class FIRAuthCredential;

NS_ASSUME_NONNULL_BEGIN

/**
    @brief A string constant identifying the Facebook identity provider.
 */
extern NSString
*
const FIRFacebookAuthProviderID NS_SWIFT_NAME(FacebookAuthProviderID);

/**
    @brief A string constant identifying the Facebook sign-in method.
 */
extern NSString *const _Nonnull
FIRFacebookAuthSignInMethod NS_SWIFT_NAME(FacebookAuthSignInMethod);

NS_ASSUME_NONNULL_END
