import sys
import uuid
import pymongo

CONNECTION_STRING = "CONNECTION_STRING"

client = pymongo.MongoClient(CONNECTION_STRING)
uuid = uuid.uuid4().hex
customerId = sys.argv[1]
new_customerId = customerId + ":deleted:" + uuid

# myaccount db processing
print('myaccount database start processing')
client["myaccount"]["userDetails"].update_one({"email": customerId}, {
                                              "$set": {"email": new_customerId, "nickName": "deleted:" + uuid}})

client["myaccount"]["referralBonuses"].update_many(
    {"email": customerId}, {"$set": {"customerId": new_customerId}})
client["myaccount"]["referralBonuses"].update_many(
    {"providedReferralId": customerId}, {"$set": {"providedReferralId": new_customerId}})

client["myaccount"]["scratchCard"].update_many(
    {"customerId": customerId}, {"$set": {"customerId": new_customerId}})
client["myaccount"]["scratchCard"].update_many(
    {"executorId": customerId}, {"$set": {"executorId": new_customerId}})

client["myaccount"]["userLoginJournal"].update_many(
    {"email": customerId}, {"$set": {"email": new_customerId}})

client["myaccount"]["userLoginWhiteList"].update_one(
    {"email": customerId}, {"$set": {"email": new_customerId}})

client["myaccount"]["userStake"].update_many(
    {"customerId": customerId}, {"$set": {"customerId": new_customerId}})

client["myaccount"]["userTradeApiDetails"].update_one(
    {"email": customerId}, {"$set": {"email": new_customerId}})

client["myaccount"]["balanceDetailsTransaction"].update_many({"customerBalanceDto.customerId": customerId}, {
                                                             "$set": {"customerBalanceDto.customerId": new_customerId}})

client["myaccount"]["userPreferences"].delete_one({"_id": customerId})

print('myaccount database processed')

# verification db processing
print('verification database start processing')
client["verification"]["customerFiles"].update_one(
    {"customerId": customerId}, {"$set": {"customerId": new_customerId}})

client["verification"]["customerGdprData"].update_one(
    {"email": customerId}, {"$set": {"email": new_customerId}})

client["verification"]["customerKycData"].update_one(
    {"email": customerId}, {"$set": {"email": new_customerId}})
print('verification database processed')
