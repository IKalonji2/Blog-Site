export interface User {
  username: string;
}

export interface UserTokens {
  access_token: string;
  expires_in: number;
  id_token: string;
  refresh_token: string;
  token_type: string;
}
