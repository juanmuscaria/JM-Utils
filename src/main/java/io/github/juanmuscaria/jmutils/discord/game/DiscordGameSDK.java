package io.github.juanmuscaria.jmutils.discord.game;

import com.sun.jna.Library;
import com.sun.jna.Structure;
import com.sun.jna.ptr.PointerByReference;
import io.github.juanmuscaria.jmutils.discord.game.struct.DiscordCreateParams;

public interface DiscordGameSDK extends Library {

    int DISCORD_VERSION = 2;
    int DISCORD_APPLICATION_MANAGER_VERSION = 1;
    int DISCORD_USER_MANAGER_VERSION = 1;
    int DISCORD_IMAGE_MANAGER_VERSION = 1;
    int DISCORD_ACTIVITY_MANAGER_VERSION = 1;
    int DISCORD_RELATIONSHIP_MANAGER_VERSION = 1;
    int DISCORD_LOBBY_MANAGER_VERSION = 1;
    int DISCORD_NETWORK_MANAGER_VERSION = 1;
    int DISCORD_OVERLAY_MANAGER_VERSION = 1;
    int DISCORD_STORAGE_MANAGER_VERSION = 1;
    int DISCORD_STORE_MANAGER_VERSION = 1;
    int DISCORD_VOICE_MANAGER_VERSION = 1;
    int DISCORD_ACHIEVEMENT_MANAGER_VERSION = 1;

    @Deprecated
    int DiscordCreate(int version, DiscordCreateParams params, PointerByReference result);

    int DiscordCreate(int version, DiscordCreateParams params, Structure.ByReference[] result);

    interface EDiscordResult {
        int DiscordResult_Ok = 0;
        int DiscordResult_ServiceUnavailable = 1;
        int DiscordResult_InvalidVersion = 2;
        int DiscordResult_LockFailed = 3;
        int DiscordResult_InternalError = 4;
        int DiscordResult_InvalidPayload = 5;
        int DiscordResult_InvalidCommand = 6;
        int DiscordResult_InvalidPermissions = 7;
        int DiscordResult_NotFetched = 8;
        int DiscordResult_NotFound = 9;
        int DiscordResult_Conflict = 10;
        int DiscordResult_InvalidSecret = 11;
        int DiscordResult_InvalidJoinSecret = 12;
        int DiscordResult_NoEligibleActivity = 13;
        int DiscordResult_InvalidInvite = 14;
        int DiscordResult_NotAuthenticated = 15;
        int DiscordResult_InvalidAccessToken = 16;
        int DiscordResult_ApplicationMismatch = 17;
        int DiscordResult_InvalidDataUrl = 18;
        int DiscordResult_InvalidBase64 = 19;
        int DiscordResult_NotFiltered = 20;
        int DiscordResult_LobbyFull = 21;
        int DiscordResult_InvalidLobbySecret = 22;
        int DiscordResult_InvalidFilename = 23;
        int DiscordResult_InvalidFileSize = 24;
        int DiscordResult_InvalidEntitlement = 25;
        int DiscordResult_NotInstalled = 26;
        int DiscordResult_NotRunning = 27;
        int DiscordResult_InsufficientBuffer = 28;
        int DiscordResult_PurchaseCanceled = 29;
        int DiscordResult_InvalidGuild = 30;
        int DiscordResult_InvalidEvent = 31;
        int DiscordResult_InvalidChannel = 32;
        int DiscordResult_InvalidOrigin = 33;
        int DiscordResult_RateLimited = 34;
        int DiscordResult_OAuth2Error = 35;
        int DiscordResult_SelectChannelTimeout = 36;
        int DiscordResult_GetGuildTimeout = 37;
        int DiscordResult_SelectVoiceForceRequired = 38;
        int DiscordResult_CaptureShortcutAlreadyListening = 39;
        int DiscordResult_UnauthorizedForAchievement = 40;
        int DiscordResult_InvalidGiftCode = 41;
        int DiscordResult_PurchaseError = 42;
        int DiscordResult_TransactionAborted = 43;
    }

    interface EDiscordCreateFlags {
        int DiscordCreateFlags_Default = 0;
        int DiscordCreateFlags_NoRequireDiscord = 1;
    }

    interface EDiscordLogLevel {
        int DiscordLogLevel_Error = 1;
        int DiscordLogLevel_Warn = 2;
        int DiscordLogLevel_Info = 3;
        int DiscordLogLevel_Debug = 4;
    }

    interface EDiscordUserFlag {
        int DiscordUserFlag_Partner = 2;
        int DiscordUserFlag_HypeSquadEvents = 4;
        int DiscordUserFlag_HypeSquadHouse1 = 64;
        int DiscordUserFlag_HypeSquadHouse2 = 128;
        int DiscordUserFlag_HypeSquadHouse3 = 256;
    }

    interface EDiscordPremiumType {
        int DiscordPremiumType_None = 0;
        int DiscordPremiumType_Tier1 = 1;
        int DiscordPremiumType_Tier2 = 2;
    }

    interface EDiscordImageType {
        int DiscordImageType_User = 0;
    }

    interface EDiscordActivityType {
        int DiscordActivityType_Playing = 0;
        int DiscordActivityType_Streaming = 1;
        int DiscordActivityType_Listening = 2;
        int DiscordActivityType_Watching = 3;
    }

    interface EDiscordActivityActionType {
        int DiscordActivityActionType_Join = 1;
        int DiscordActivityActionType_Spectate = 2;
    }

    interface EDiscordActivityJoinRequestReply {
        int DiscordActivityJoinRequestReply_No = 0;
        int DiscordActivityJoinRequestReply_Yes = 1;
        int DiscordActivityJoinRequestReply_Ignore = 2;
    }

    interface EDiscordStatus {
        int DiscordStatus_Offline = 0;
        int DiscordStatus_Online = 1;
        int DiscordStatus_Idle = 2;
        int DiscordStatus_DoNotDisturb = 3;
    }

    interface EDiscordRelationshipType {
        int DiscordRelationshipType_None = 0;
        int DiscordRelationshipType_Friend = 1;
        int DiscordRelationshipType_Blocked = 2;
        int DiscordRelationshipType_PendingIncoming = 3;
        int DiscordRelationshipType_PendingOutgoing = 4;
        int DiscordRelationshipType_Implicit = 5;
    }

    interface EDiscordLobbyType {
        int DiscordLobbyType_Private = 1;
        int DiscordLobbyType_Public = 2;
    }

    interface EDiscordLobbySearchComparison {
        int DiscordLobbySearchComparison_LessThanOrEqual = -2;
        int DiscordLobbySearchComparison_LessThan = -1;
        int DiscordLobbySearchComparison_Equal = 0;
        int DiscordLobbySearchComparison_GreaterThan = 1;
        int DiscordLobbySearchComparison_GreaterThanOrEqual = 2;
        int DiscordLobbySearchComparison_NotEqual = 3;
    }

    interface EDiscordLobbySearchCast {
        int DiscordLobbySearchCast_String = 1;
        int DiscordLobbySearchCast_Number = 2;
    }

    interface EDiscordLobbySearchDistance {
        int DiscordLobbySearchDistance_Local = 0;
        int DiscordLobbySearchDistance_Default = 1;
        int DiscordLobbySearchDistance_Extended = 2;
        int DiscordLobbySearchDistance_Global = 3;
    }

    interface EDiscordEntitlementType {
        int DiscordEntitlementType_Purchase = 1;
        int DiscordEntitlementType_PremiumSubscription = 2;
        int DiscordEntitlementType_DeveloperGift = 3;
        int DiscordEntitlementType_TestModePurchase = 4;
        int DiscordEntitlementType_FreePurchase = 5;
        int DiscordEntitlementType_UserGift = 6;
        int DiscordEntitlementType_PremiumPurchase = 7;
    }

    interface EDiscordSkuType {
        int DiscordSkuType_Application = 1;
        int DiscordSkuType_DLC = 2;
        int DiscordSkuType_Consumable = 3;
        int DiscordSkuType_Bundle = 4;
    }

    interface EDiscordInputModeType {
        int DiscordInputModeType_VoiceActivity = 0;
        int DiscordInputModeType_PushToTalk = 1;
    }
}
